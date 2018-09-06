package com.organOld.oService.service;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.oService.contract.AutoValRequest;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;

import java.util.List;

public interface AutoValService {
    List<AutoValue> getByType(int index);

    String getByPage(AutoValRequest autoValRequest, BTableRequest bTableRequest);

    Conse getById(int id);

    void handle(String type, AutoValue autoValue);

    void delByIds(String[] ids);

    List<AutoValue> getByIds(String[] sq);

    Xq getXqById(Integer xqId);

    List<AutoValue> getByTypeList(List<Integer> type);

    List<Integer> getXqIdsByJwIds(String[] jw);

    List<Integer> getXqIdsByPqIds(String[] district);

    List<Integer> getXqIdsByUsername(String userNameBySession);

    Integer getStringLikeIndex(String stringCellValue, int index, String like);
}
