package com.organOld.oService.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.OrganRegDao;
import com.organOld.dao.repository.OrganTypeDao;
import com.organOld.oService.constant.Constant;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.OrganTypeModel;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OrganService;
import com.organOld.oService.wrapper.OrganTypeWrap;
import com.organOld.oService.wrapper.OrganWrap;
import  com.organOld.dao.entity.organ.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganServiceImpl implements OrganService {
    @Autowired
    OrganWrap organWrapper;
    @Autowired
    OrganDao organDao;
    @Autowired
    OrganRegDao organRegDao;
    @Autowired
    OrganTypeDao organTypeDao;
    @Autowired
    OrganTypeWrap organTypeWrapper;
    @Autowired
    ComService comService;

    @Override
    @Transactional
    public Conse reg(OrganRegRequest organRegRequest, HttpServletRequest request){
        Organ organ=organWrapper.unwrapRegOrgan(organRegRequest,request);
        organ.setStatus("1");
        OrganReg organReg=organWrapper.unwrapRegOrganReg(organRegRequest);
        organDao.save(organ);
        organReg.setOrganId(organ.getId());
        organRegDao.save(organReg);
        return new Conse(true,"注册成功！请等待审核");
    }

    @Override
    public Conse getOrganTypes(){
        List<String> ids = new ArrayList<>();
        ids.add("23");
        ids.add("24");
        ids.add("26");
        ids.add("27");
        ids.add("28");
        ids.add("29");
        ids.add("35");
        ids.add("36");
        ids.add("37");
        List<OrganTypeModel> organTypeModels = organTypeDao.getByIds(ids).stream().map(organTypeWrapper::wrap).collect(Collectors.toList());
        return new Conse(true,organTypeModels);
    }

    @Override
    public Conse getTypes(){
        List<String> ids = new ArrayList<>();
        ids.add("11");
        ids.add("12");
        ids.add("62");
        ids.add("83");
        ids.add("86");
        ids.add("96");
        List<OrganTypeModel> organTypeModels = organDao.getByIds(ids).stream().map(organTypeWrapper::wrapDis).collect(Collectors.toList());
        Integer disId[] = {1,2,6,3,4,5};
        Integer i = 0;
        for(OrganTypeModel organTypeModel:organTypeModels){
            List<AutoValModel> jws = organDao.getJwByDis(disId[i]).stream().map(organWrapper::wrapJw).collect(Collectors.toList());
            organTypeModel.setOrgans(jws);
            ++i;
        }
        return new Conse(true,comService.JwReturn(organTypeModels));
    }
    @Override
    public Conse getOrganInfo(Integer organId){
        Organ organ = organDao.getOrganDById(organId);
        String imgUrl = Constant.url ;
        if(organ.getImgUrl() != null)
        organ.setImgUrl(imgUrl+organ.getImgUrl());
        if(organ == null)
            throw new ServiceException("数据库中没有找到相关数据");
        return new Conse(true,organ);
    }

    @Override
    public Conse getOrganLocation(){
        List<Integer> ids = new ArrayList<>();
        ids.add(23);
        ids.add(24);
        ids.add(26);
        ids.add(27);
        ids.add(28);
        ids.add(29);
        ids.add(35);
        ids.add(36);
        ids.add(37);
        ids.add(2);
        List<JSONObject> jsonObjects = organDao.getByTypes(ids).stream().map(comService::mapOrganReturn).collect(Collectors.toList());
        return new Conse(true,jsonObjects);
    }
}
