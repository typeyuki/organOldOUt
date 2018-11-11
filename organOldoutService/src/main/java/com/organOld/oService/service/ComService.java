package com.organOld.oService.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.organOld.dao.entity.*;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.*;
import com.organOld.dao.repository.out.AutoValDao;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.*;
import com.organOld.oService.enumModel.AutoValEnum;
import com.organOld.oService.enumModel.MessageEnum;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.Pattern;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.tool.Cache;
import io.jsonwebtoken.Claims;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ComService {

    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    oldsUserDao oldsUDao;
    @Autowired
    AutoValDao autoValDao;
    @Autowired
    AutoValService autoValService;
    @Autowired
    CardDao cardDao;
    @Autowired
    TokenMgrService tokenMgrService;

    public static int birthdayToAge(Date birthday){
        if(birthday==null){
            return 0;
        }
        Date date=new Date();
        return calculateTwoDateYears(date,birthday);
    }
    public static Date AgeTobirthday(int age){
        if(age==0){
            return null;
        }
        Date nowDate = new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-age);
        return calendar.getTime();
    }
    OldmanDao oldmanBaseDao5;
    public static String getTabeleSortType(Integer index,String type){
        if (null == index){
            return "id";
        }
        switch (type){
            case "oldman_base":
                switch (index) {
                    case 0:
                        return "id";
                    case 5:
                        return "age";
                    case 11:
                        return "time";
                }
                return "id";
            case "message":
                return "init";
            default:
                return "id";
        }
    }


    public String tableReturn(String sEcho,Long size,List<?> list){
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", size);//总的行数
        getObj.put("iTotalDisplayRecords", size);//显示的行数,这个要和上面写的一样
        getObj.put("aaData", list);//要以JSON格式返回  jqueryDataTable 默认变量名 aaData
        return getObj.toString();
    }

    public JSONObject pageReturn(Long size,List<?> list){
        JSONObject getObj = new JSONObject();
        getObj.put("iTotalItems",size);
        getObj.put("aaData",list);
        return getObj;
    }

    public JSONObject JwReturn(List<?> list){
        JSONObject getObj = new JSONObject();
        getObj.put("organData",list);
        getObj.put("name","居委会");
        return getObj;
    }

    public JSONObject organGoodsReturn(Long size,List<?> list,String name,Integer id){
        JSONObject getObj = new JSONObject();
        getObj.put("iTotalItems",size);
        getObj.put("aaData",list);
        getObj.put("organId",id);
        getObj.put("organName",name);
        return getObj;
    }

    public JSONObject mapOrganReturn(Organ organ){
        JSONObject getObj = new JSONObject();
        getObj.put("id",organ.getId());
        getObj.put("X",organ.getMapX());
        getObj.put("Y",organ.getMapY());
        return getObj;
    }

    public JSONObject IntegralReturn(Oldman oldman){
        JSONObject getOgj = new JSONObject();
        getOgj.put("name",oldman.getName());
        getOgj.put("Integral",oldman.getIntegral());
        return getOgj;
    }

    public Page getPageOut(Integer iDisplayStart){
        Page page = new Page<>();
        page.setLength(10);
        page.setStart((iDisplayStart-1)*10);
        return page;
    }

    public Page getPage(BTableRequest bTableRequest, String type) {
        Page page = new Page<>();
        String sortType = ComService.getTabeleSortType(bTableRequest.getiSortCol_0(), type);
        String sort = bTableRequest.getsSortDir_0();
        if (StringUtils.isEmpty(sort)) {
            sort = "asc";
        }
        page.setSortType(sortType);
        page.setSort(sort);
        page.setStart(bTableRequest.getiDisplayStart());
        page.setLength(bTableRequest.getiDisplayLength());
        page.setSort(sort);
        page.setSortType(sortType);
        return page;
    }

    public List<Integer> getAutoValueTypes(String type){
        List<Integer> typeList=new ArrayList<>();
        switch (type){
            case "label":
                typeList.add(AutoValEnum.PQ.getIndex());
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                typeList.add(AutoValEnum.SL.getIndex());
                typeList.add(AutoValEnum.SZ.getIndex());
                typeList.add(AutoValEnum.SQZW.getIndex());
                typeList.add(AutoValEnum.ZC.getIndex());
                typeList.add(AutoValEnum.JTLB.getIndex());
                break;
            case "labelFilter":
                typeList.add(AutoValEnum.PQ.getIndex());
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                typeList.add(AutoValEnum.SL.getIndex());
                typeList.add(AutoValEnum.SZ.getIndex());
                typeList.add(AutoValEnum.YJBQ.getIndex());
                typeList.add(AutoValEnum.SQZW.getIndex());
                typeList.add(AutoValEnum.ZC.getIndex());
                typeList.add(AutoValEnum.JTLB.getIndex());
                break;
            case "oldman_add":
                typeList.add(AutoValEnum.PQ.getIndex());
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                typeList.add(AutoValEnum.SL.getIndex());
                typeList.add(AutoValEnum.SZ.getIndex());
                typeList.add(AutoValEnum.XQ.getIndex());
                typeList.add(AutoValEnum.SQZW.getIndex());
                typeList.add(AutoValEnum.ZC.getIndex());
                typeList.add(AutoValEnum.JTLB.getIndex());
                break;
            case "health_add":
                typeList.add(AutoValEnum.SL.getIndex());
                typeList.add(AutoValEnum.SZ.getIndex());
                break;
            case "organ_reg":
                typeList.add(AutoValEnum.PQ.getIndex());
                break;
            case "oldman":
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                break;
            case "oldmanInfo":
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                typeList.add(AutoValEnum.SQZW.getIndex());
                typeList.add(AutoValEnum.ZC.getIndex());
                typeList.add(AutoValEnum.JTLB.getIndex());
                break;
            case "importOldman":
                typeList.add(AutoValEnum.ZZMM.getIndex());
                typeList.add(AutoValEnum.HJ.getIndex());
                typeList.add(AutoValEnum.JJJG.getIndex());
                typeList.add(AutoValEnum.JJTJ.getIndex());
                typeList.add(AutoValEnum.SQZW.getIndex());
                typeList.add(AutoValEnum.ZC.getIndex());
                typeList.add(AutoValEnum.JTLB.getIndex());
                typeList.add(AutoValEnum.SL.getIndex());
                typeList.add(AutoValEnum.SZ.getIndex());
                typeList.add(AutoValEnum.XQ.getIndex());
                break;
            default:
        }
        return typeList;
    }


    public Integer getIdBySession() {
        try {
            Integer organId= userDao.getOrganIdByUsername(getUserNameBySession());
            if(organId==null) return 0;
            return organId;
        }catch (Exception e){
            return 0;
        }
    }

    public Integer getOldsIdBySession(){
        try{
            Integer oldmanId = oldsUDao.getOldsIdByUsername(getUserNameBySession());
            if(oldmanId == null) return 0;
            return oldmanId;
        }catch (Exception e){
            return 0;
        }
    }

    public void checkIsOrgan(DBInterface dbInterface) {
        Integer organId=getIdBySession();
        if (organId!=null && organId!=0){
            dbInterface.setOrganId(organId);
        }
    }

    public void checkIsUser(DBInterface dbInterface){
        Integer oldmanId = getOldsIdBySession();
        if(oldmanId != null && oldmanId != 0)
            dbInterface.setOrganId(oldmanId);
    }


    public void getOrganXqs(XqInterface xqInterface) {
        if(xqInterface.getXqIds()==null || xqInterface.getXqIds().size()==0) {
            Integer organId = getIdBySession();
            if (organId == null || organId == 0) {
                //管理员
                xqInterface.setXqIds(null);
            } else {
                List<Integer> xqIds = autoValService.getXqIdsByUsername(getUserNameBySession());
                xqInterface.setXqIds(xqIds);
            }
        }

    }

    public List<Integer> getOrganXqs() {
        Integer organId = getIdBySession();
        if (organId == null || organId == 0) {
            //管理员
            return null;
        } else {
            List<Integer> xqIds = autoValService.getXqIdsByUsername(getUserNameBySession());
            return xqIds;
        }


    }

    public static int calculateTwoDateYears(String futureTime, Date birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(futureTime);
        return calculateTwoDateYears(date,birthday);
    }

    public static int calculateTwoDateYears(Date time, Date birthday){
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        //只比较 年  不比较月
//        if (monthNow <= monthBirth) {
//            if (monthNow == monthBirth) {
//                if (dayOfMonthNow < dayOfMonthBirth) age--;
//            }else{
//                age--;
//            }
//        }
        return age;
    }

    public Conse checkUserOrganType() {
        Conse conse;
        try {
            UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            String username=userDetails.getUsername();
            String type=userDao.getOrganTypeByUsername(username);
            if(type!=null &&!type.equals("")){
                conse =new Conse(true,type);
            }else{
                conse =new Conse(false);
            }
        }catch (Exception e){
            conse =new Conse(false);
        }
        return conse;
    }

    public void informJwAndPq(String content) {
        Conse conse =checkUserOrganType();
        if(conse.isSuccess()==false || conse.getData().equals("片区")){
            Integer organId=getIdBySession();
            List<Integer> userIds=userDao.getJwUserId(organId);
            Message message=new Message();
            message.setType(MessageEnum.XT.getIndex());
            message.setContent(content);
            messageDao.saveAllMessage(userIds,message);
        }
    }

    public Integer checkOldmanExiest(String pid) {
        return oldmanDao.getIdByPid(pid);
    }


    public String getUserNameBySession() {
        try {
            UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            String username=userDetails.getUsername();
            return username;
        }catch (Exception e){
            return "";
        }
    }

    public Integer getUserByToken(HttpServletRequest request){
        try{
        String url =request.getServletPath().toString();
        String tokenStr = request.getParameter("token");
        Claims claims = null;
        claims = tokenMgrService.parseJWT(tokenStr);
        String username = claims.getId();
        Integer oldmanId = oldsUDao.getOldsIdByUsername(username);
        if(Cache.checkCacheName(tokenStr))
            return oldmanId;
        else return 0;
       }
        catch(Exception e){
            return 0;
        }

    }

    public boolean PwdComparedBySession(String originPwd){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(userDetails == null)
            throw new ServiceException("找不到账户信息");
        String password = userDetails.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean f = bCryptPasswordEncoder.matches(originPwd,password);
        return f;
    }

    public Boolean excelIsNotNull(Cell cell){
        if(cell==null || cell.getStringCellValue()==null || cell.getStringCellValue().trim().equals("")){
            return false;
        }
        return true;
    }

    public boolean excelIsNotNullOne(Cell cell) {
        Boolean result=excelIsNotNull(cell);
        if(result){
            if(cell.getStringCellValue().equals("1"))
                return true;
        }
        return false;
    }


    public void fillAutoValue(DBEntity entity, Pattern pattern, List<String> methods, Map<Integer,String> map)  {
        try {
            for(String method : methods){
                String setM="set"+method;
                String getM="get"+method;
                Method setMethod;
                if (method.equals("Sqzw") || method.equals("FamilyType") || method.equals("Economic") || method.equals("Family")){
                    setMethod= pattern.getClass().getMethod(setM, List.class);
                }else{
                    setMethod= pattern.getClass().getMethod(setM, String.class);
                }
                Method getMethod =entity.getClass().getMethod(getM, null);

                String value=(String)getMethod.invoke(entity,null);
                if(value!=null && !value.equals("")){
                    if (method.equals("Sqzw") || method.equals("FamilyType") || method.equals("Economic") || method.equals("Family")){
                        String[] s=value.split("#");
                        List<String> sList=new ArrayList<>();
                        for(String ss:s){
                            sList.add(map.get(Integer.parseInt(ss)));
                        }
                        setMethod.invoke(pattern,sList);
                    }else{
                        setMethod.invoke(pattern,map.get(Integer.parseInt(value)));
                    }

                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //填充小区 1.筛选片区、居委 2.本身机构对应的小区
    public void fillXq(NeiboRequest neiboRequest, XqInterface xqInterface) {
        List<Integer> xqIds=new ArrayList<>();
        if(neiboRequest !=null && neiboRequest.getJw()!=null && neiboRequest.getJw().length>0){
            xqIds= autoValService.getXqIdsByJwIds(neiboRequest.getJw());
        }else if(neiboRequest !=null && neiboRequest.getDistrict()!=null && neiboRequest.getDistrict().length>0){
            xqIds= autoValService.getXqIdsByPqIds(neiboRequest.getDistrict());
        }
        xqInterface.setXqIds(xqIds);
        getOrganXqs(xqInterface);
    }

    public void fillXqIds(String jwId,XqInterface xqInterface){
        List<Integer> xqIds = new ArrayList<>();
        xqIds = autoValDao.getXqIdsByJwId(jwId);
        xqInterface.setXqIds(xqIds);
        getOrganXqs(xqInterface);
    }

    public String getPrevNy() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format( cal.getTime());
    }
}

