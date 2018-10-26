package com.organOld.oService.service.impl;

import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.OrganRegDao;
import com.organOld.dao.repository.OrganTypeDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.model.OrganTypeModel;
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
        ids.add("26");
        ids.add("27");
        ids.add("28");
        ids.add("29");
        List<OrganTypeModel> organTypeModels = organTypeDao.getByIds(ids).stream().map(organTypeWrapper::wrap).collect(Collectors.toList());
        return new Conse(true,organTypeModels);
    }
}
