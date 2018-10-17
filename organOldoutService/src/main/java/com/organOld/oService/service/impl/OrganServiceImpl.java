package com.organOld.oService.service.impl;

import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.OrganRegDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.service.OrganService;
import com.organOld.oService.wrapper.OrganWrap;
import  com.organOld.dao.entity.organ.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
@Service
public class OrganServiceImpl implements OrganService {
    @Autowired
    OrganWrap organWrapper;
    @Autowired
    OrganDao organDao;
    @Autowired
    OrganRegDao organRegDao;

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
}
