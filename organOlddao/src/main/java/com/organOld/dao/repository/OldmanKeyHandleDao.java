package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKeyHandle;

import java.util.List;

public interface OldmanKeyHandleDao extends BaseDao<OldmanKeyHandle,Number> {
    OldmanKeyHandle getByOldmanId(int oldmanId);

    void updateByOldmanId(OldmanKeyHandle oldmanKeyHandle);

    void delByOldmanId(int oldmanId);

    void delByOldman(List<Oldman> oldmanList);

    void delByOldmanIds(String[] oldmanIds);
}
