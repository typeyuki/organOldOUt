package com.organOld.oService.service.impl;

import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.model.*;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.FileService;
import com.organOld.oService.wrapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PersonalInfoModel personalInfoModel = new PersonalInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setLength(1);
        page.setStart(0);

        Oldman oldman=new Oldman();
        oldman.setId(comService.getIdBySession());
        OldsModel oldsModel = oldmanWrapper.wrapOldInfo(oldmanBaseDao.getById(oldman.getId()));
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
        return oldsHealthWrapper.wrap(oldmanHealthDao.getByOldmanId(comService.getIdBySession()));
    }
    @Override
    public String getByCardPage(BTableRequest bTableRequest, CardLogsRequest cardLogsRequest) {
        Page<Record> page= comService.getPage(bTableRequest,"record");
        cardLogsRequest.setOldmanId(comService.getIdBySession());
        Record record = logsWrapper.unwrapCard(cardLogsRequest);
        page.setEntity(record);
        List<LogsModel> productModelList=recordDao.getByCardPage(page).stream().map( logsWrapper::wrap).collect(Collectors.toList());
        Long size=recordDao.getSizeByCardPage(page);
        return comService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }


    @Override
    public Conse getByLabel (int oldmanId){
        List<LabelInfoModel> labels = labelDao.getManLabelByOldmanId(comService.getIdBySession()).stream().map(labelWrapper::wrap).collect(Collectors.toList());
        return new Conse(true,labels);
    }
}
