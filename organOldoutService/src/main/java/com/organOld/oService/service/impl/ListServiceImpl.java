package com.organOld.oService.service.impl;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.OrganDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.ListRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.OrganModel;
import com.organOld.oService.service.ListService;
import com.organOld.oService.wrapper.ListWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
@Service
public class ListServiceImpl implements ListService {
    @Autowired
    OrganDao organDao;
    @Autowired
    ListWrap listWrapper;
    @Override
    public Conse getOrgAutoValue(ListRequest listRequest){
        List<Integer> firTypes = listWrapper.unwarpList(listRequest);
        List<AutoValModel> autoValModels = new ArrayList<>();
        if(listRequest.getType() == 0){
            autoValModels = organDao.getAutoValueByIds(firTypes).stream().map(listWrapper::wrap).collect(Collectors.toList());
            return new Conse(true,autoValModels);
        }
        else if(listRequest.getType() == 1){
            List<OrganModel> organModels = organDao.getAutoValueByIds(firTypes).stream().map(listWrapper::wrapList).collect(Collectors.toList());
            return new Conse(true,organModels);
        }
        return new Conse(false);
    }

    @Override
    public Conse getOrganInfo(int organId){
        Organ organ = organDao.getSimpleById(organId);
        OrganModel organModel = listWrapper.wrapOrgan(organ);
        return new Conse(true,organModel);
    }


}
