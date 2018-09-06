package com.organOld.oService.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.AutoValRequest;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.service.AutoValService;
import com.organOld.oService.service.ComService;
import com.organOld.oService.wrapper.AutoValWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoValServiceImpl implements AutoValService {

    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    ComService comService;
    @Autowired
    AutoValWrap autoValWrapper;

    @Override
    public List<AutoValue> getByType(int type) {
        return autoValueDao.getByType(type);
    }


    @Override
    public String getByPage(AutoValRequest autoValRequest, BTableRequest bTableRequest) {
        Page<AutoValue> page= comService.getPage(bTableRequest,"auto_value");
        AutoValue autoValue= autoValWrapper.unwrap(autoValRequest);
        page.setEntity(autoValue);
        List<AutoValModel> autoValModelList =autoValueDao.getByPage(page).stream().map(autoValWrapper::wrap).collect(Collectors.toList());
        Long size=autoValueDao.getSizeByPage(page);
        return comService.tableReturn(bTableRequest.getsEcho(),size, autoValModelList);
    }

    @Override
    public Conse getById(int id) {
        return new Conse(true,autoValueDao.getById(id));
    }

    @Override
    public void handle(String type, AutoValue autoValue) {
        if(type.equals("add")){
            autoValueDao.save(autoValue);
        }else{
            autoValueDao.updateById(autoValue);
        }
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        autoValueDao.delByIds(id);
    }

    @Override
    public List<AutoValue> getByIds(String[] sq) {
        return autoValueDao.getByIds(sq);
    }

    @Override
    public Xq getXqById(Integer xqId) {
        return autoValueDao.getXqById(xqId);
    }


    @Override
    public List<AutoValue> getByTypeList(List<Integer> type) {
        return autoValueDao.getByTypeList(type);
    }


    @Override
    public List<Integer> getXqIdsByJwIds(String[] jw) {
        return autoValueDao.getXqIdsByJwIds(jw);
    }

    @Override
    public List<Integer> getXqIdsByPqIds(String[] district) {
        return autoValueDao.getXqIdsByPqIds(district);
    }

    @Override
    public List<Integer> getXqIdsByUsername(String userNameBySession) {
        return autoValueDao.getXqIdsByUsername(userNameBySession);
    }

    @Override
    public Integer getStringLikeIndex(String stringCellValue, int index, String like) {
        return autoValueDao.getStringLikeIndex(stringCellValue,index,like);
    }
}
