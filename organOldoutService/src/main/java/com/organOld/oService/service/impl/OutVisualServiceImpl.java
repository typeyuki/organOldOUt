package com.organOld.oService.service.impl;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.out.AutoValDao;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OldmanRequest;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OutVisualService;
import com.organOld.oService.wrapper.OldmanWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OutVisualServiceImpl implements OutVisualService {
    @Autowired
    OldmanDao oldmanBaseDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    AutoValDao autoValDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    ComService comService;
    @Autowired
    OldmanWrap oldmanWrapper;
    @Override
    public Conse getNeiborComAndNum(OldmanRequest oldmanRequest, BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= oldmanWrapper.unwrap(oldmanRequest);
        List<Map<String,Long>> dataMap = new ArrayList<>();
        String[] jwIds = oldmanRequest.getJw();
        if(jwIds.length > 0)
            for(int i=0;i<jwIds.length;++i)
            {
                String jwId = jwIds[i];
                comService.fillXqIds(jwId,oldman);
                page.setEntity(oldman);
                Long size=oldmanBaseDao.getSizeByPage(page);
                int id = Integer.parseInt(jwId);
                String name = organDao.getNameById(id);
                Map<String,Long> map = new HashMap();
                map.put(name,size);
                dataMap.add(map);
            }
            return new Conse(true,dataMap);
    }
}
