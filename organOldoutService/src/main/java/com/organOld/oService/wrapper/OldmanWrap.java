package com.organOld.oService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.oService.Tool;
import com.organOld.oService.enumModel.GenderEnum;
import com.organOld.oService.contract.OldmanRequest;
import com.organOld.oService.model.OldsModel;
import com.organOld.oService.service.AutoValService;
import com.organOld.oService.service.ComService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OldmanWrap implements Wrap<Oldman,OldsModel,OldmanRequest> {
    @Autowired
    ComService comService;
    @Autowired
    AutoValService autoValService;

    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();

    List<String> methodInfo=new ArrayList<>();
    Map<Integer,String> mapInfo=new HashMap<>();
    @Override
    public OldsModel wrap(Oldman oldman) {
        OldsModel oldsModel =new OldsModel();
        oldsModel.setId(oldman.getId()+"");
        oldsModel.setName(oldman.getName());
        if(oldman.getBirthday()!=null)
            oldsModel.setAge(ComService.birthdayToAge(oldman.getBirthday()));
        oldsModel.setSex(GenderEnum.getValue(oldman.getSex()));
        Xq xq = autoValService.getXqById(oldman.getXqId());
        if(xq != null){
            oldsModel.setNeighbour(xq.getName());
            oldsModel.setNeiboCom(xq.getJwName());
            oldsModel.setArea(xq.getDistrictName());
        }
        if(method.size()==0){
            method.add("Family");
            method.add("Economic");
            method.add("Census");
            method.add("PoliticalStatus");
        }
        if(map.size()==0){
            List<Integer> autoIds= comService.getAutoValueTypes("oldman");
            List<AutoValue> autoValueList= autoValService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        comService.fillAutoValue(oldman, oldsModel,method,map);
        return oldsModel;
    }

    @Override
    public Oldman unwrap(OldmanRequest oldmanRequest) {

        Oldman oldman=new Oldman();
        BeanUtils.copyProperties(oldmanRequest,oldman);
//        if(oldmanRequest.getSqzwArray()!=null && oldmanRequest.getSqzwArray().length>0){
//            for(String s:oldmanRequest.getSqzwArray()){
//                oldman.getSqzwArray().add("s"+s+"s");
//            }
//        }

        if(oldmanRequest.getAgeStart()!=null && !oldmanRequest.getAgeStart().equals(""))
            oldman.setBirthdayEnd(comService.AgeTobirthday(Integer.parseInt(oldmanRequest.getAgeStart())));
        if(oldmanRequest.getAgeEnd()!=null && !oldmanRequest.getAgeEnd().equals(""))
            oldman.setBirthdayStart(comService.AgeTobirthday(Integer.parseInt(oldmanRequest.getAgeEnd())));



        return oldman;
    }

    public OldsModel wrapOldInfo(Oldman oldman){
        OldsModel oldsModel =new OldsModel();
        oldsModel.setId(oldman.getId()+"");
        oldsModel.setName(oldman.getName());
        oldsModel.setBuildNum(oldman.getLouNum()+"");
        oldsModel.setAddress(oldman.getAddress());
        oldsModel.setIdNum(oldman.getPid());
        oldsModel.setTime(Tool.dateToString(oldman.getTime(),"yyyy-MM-dd"));
        oldsModel.setPhone(oldman.getPhone());
        if(oldman.getBirthday()!=null)
            oldsModel.setAge(ComService.birthdayToAge(oldman.getBirthday()));
        oldsModel.setSex(GenderEnum.getValue(oldman.getSex()));
        Xq xq = autoValService.getXqById(oldman.getXqId());
        if(xq != null){
            oldsModel.setNeighbour(xq.getName());
            oldsModel.setNeiboCom(xq.getJwName());
            oldsModel.setArea(xq.getDistrictName());
        }
        if(method.size()==0){
            method.add("Family");
            method.add("Economic");
            method.add("Census");
            method.add("PoliticalStatus");
        }
        if(map.size()==0){
            List<Integer> autoIds= comService.getAutoValueTypes("oldman");
            List<AutoValue> autoValueList= autoValService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        comService.fillAutoValue(oldman, oldsModel,method,map);
        return oldsModel;
    }
}
