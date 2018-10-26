package com.organOld.oService.wrapper;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganType;
import com.organOld.dao.repository.OrganTypeDao;
import com.organOld.oService.contract.OrganRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.OrganTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganTypeWrap implements Wrap<OrganType,OrganTypeModel,OrganRequest> {
    @Autowired
    OrganTypeDao organTypeDao;
    @Autowired
    ListWrap listWrapper;
    @Override
    public OrganType unwrap(OrganRequest organRequest){
        return null;
    }

    @Override
    public OrganTypeModel wrap(OrganType organType){
        OrganTypeModel organTypeModel = new OrganTypeModel();
        organTypeModel.setId(organType.getId());
        organTypeModel.setOrganName(organType.getSecType());
        List<AutoValModel> organList = organTypeDao.getOrgansByType(organType.getId()).stream().map(listWrapper::wrap).collect(Collectors.toList());
        organTypeModel.setOrgans(organList);
        return organTypeModel;
    }
}
