package com.organOld.oService.service.impl;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanHealth;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.*;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.*;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.FileService;
import com.organOld.oService.wrapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    OldmanDao oldmanBaseDao;
    @Autowired
    OldmanHealthDao oldmanHealthDao;
    @Autowired
    LinkmanDao linkmanDao;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ComService comService;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    RecordDao recordDao;
    @Autowired
    LabelDao labelDao;
    @Autowired
    OldmanWrap oldmanWrapper;
    @Autowired
    ContactsWrap contactsWrapper;
    @Autowired
    OldsHealthWrap oldsHealthWrapper;
    @Autowired
    LogsWrap logsWrapper;
    @Autowired
    GoodsWrap goodsWrapper;
    @Autowired
    OrganOldsWrap organOldsWrapper;
    @Autowired
    HomeOldsWrap homeOldsWrapper;
    @Autowired
    LabelWrap labelWrapper;
    @Override
    public PersonalInfoModel getPersonalInfo (int oldmanId){
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            userId = oldmanId;
        if (userId == 0)
            throw new ServiceException("请登录");
        PersonalInfoModel personalInfoModel = new PersonalInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setLength(1);
        page.setStart(0);
        //comService.getIdBySession()
        Oldman oldman=new Oldman();
        oldman.setId(userId);
        oldman = oldmanBaseDao.getById(oldman.getId());
        if(oldman == null)
            throw new ServiceException("错误！老人信息不存在！");
        if(oldman.getDisable() == 1)
            throw new ServiceException("该老人账号已被注销!");
        OldsModel oldsModel = oldmanWrapper.wrapOldInfo(oldman);

        personalInfoModel.setOldman(oldsModel);
        Linkman linkman=new Linkman();
        linkman.setOldman(oldman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(contactsWrapper::wrap).collect(Collectors.toList());
        if(linkmanModelList!=null && linkmanModelList.size()>0)
            personalInfoModel.setLinkman(linkmanModelList.get(0));

        OrganOldman organOldman = new OrganOldman();//机构养老
        organOldman.setOldman(oldman);
        organOldman.setFirType(21);
        organOldman.setNy(comService.getPrevNy());
        page.setEntity(organOldman);
        List<OrganOldsModel> organOldsModelList = organOldmanDao.getByPage(page).stream().map(organOldsWrapper::wrap).collect(Collectors.toList());
        if(organOldsModelList != null && organOldsModelList.size() > 0)
            personalInfoModel.setOrgan(organOldsModelList.get(0));

        OrganOldman communityOldman = new OrganOldman();//社区养老
        communityOldman.setFirType(22);
        communityOldman.setOldman(oldman);
        communityOldman.setNy(comService.getPrevNy());
        page.setEntity(communityOldman);
        List<OrganOldsModel> communityOldsModel = organOldmanDao.getByPage(page).stream().map(organOldsWrapper::wrap).collect(Collectors.toList());
        personalInfoModel.setCommunity(communityOldsModel);

        HomeOldman homeOldman = new HomeOldman();//居家养老
        homeOldman.setOldman(oldman);
        homeOldman.setNy(comService.getPrevNy());
        page.setEntity(homeOldman);
        List<HomeOldsModel> homeOldsModelList = homeOldmanDao.getByPage(page).stream().map(homeOldsWrapper::wrap).collect(Collectors.toList());
        personalInfoModel.setHome(homeOldsModelList);

        return personalInfoModel;
    }

    @Override
    public OldsHealthModel getOldmanHealth (int oldmanId){
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            userId = oldmanId;
        if (userId == 0)
            throw new ServiceException("请登录");
        OldmanHealth oldmanHealth = oldmanHealthDao.getByOldmanId(userId);
        if(oldmanHealth == null)
            throw new ServiceException("错误！健康信息不存在!");
        return oldsHealthWrapper.wrap(oldmanHealth);//comService.getIdBySession()));
    }
    @Override
    public String getByCardPage(BTableRequest bTableRequest, CardLogsRequest cardLogsRequest) {
        Page<Record> page= comService.getPage(bTableRequest,"record");
        //cardLogsRequest.setOldmanId(comService.getIdBySession());
        Record record = logsWrapper.unwrapCard(cardLogsRequest);
        if(record.getOldmanId()==null || record.getOldmanId() == 0)
            comService.checkIsUser(record);
        if(record.getOldmanId()==null || record.getOldmanId() == 0)
            throw new OtherServiceException("请先登录");
        page.setEntity(record);
        List<LogsModel> productModelList=recordDao.getByCardPage(page).stream().map( logsWrapper::wrap).collect(Collectors.toList());
        Long size=recordDao.getSizeByCardPage(page);
        if(productModelList.size() == 0 || size == 0 )
            throw new OtherServiceException("目前没有扫码记录。");
        return comService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public String getByLogPage(LogsRequest logsRequest,BTableRequest bTableRequest){
        Page<Record> page = comService.getPage(bTableRequest,"record");
        Record record = logsWrapper.unwrap(logsRequest);
        if(record.getOldmanId()==null || record.getOldmanId() == 0)
            comService.checkIsUser(record);
        if(record.getOldmanId()==null || record.getOldmanId() == 0)
            throw new OtherServiceException("请先登录");
        page.setEntity(record);
        List<LogsModel> logsModelList = recordDao.getByPage(page).stream().map(logsWrapper::wrap).collect(Collectors.toList());
        Long size = recordDao.getSizeByPage(page);
        if(logsModelList.size() == 0|| size == 0)
            throw new OtherServiceException("目前没有积分记录");
        return comService.tableReturn(bTableRequest.getsEcho(),size,logsModelList);
    }

    @Override
    public Conse getByLabel (int oldmanId){
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            userId = oldmanId;
        if (userId == 0)
            throw new ServiceException("请登录");
        List<LabelInfoModel> labels = labelDao.getManLabelByOldmanId(userId).stream().map(labelWrapper::wrap).collect(Collectors.toList());
        return new Conse(true,labels);
        //comService.getIdBySession()
    }

    @Override
    public Conse getOldsIntegral(int oldmanId){
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            userId = oldmanId;
        if (userId == 0)
            throw new ServiceException("请登录");
        Oldman oldman = oldmanBaseDao.getIntegralByOldmanId(userId);
        OldsModel oldsModel = oldmanWrapper.wrapIntegral(oldman);
        return new Conse(true,oldsModel);
    }
}
