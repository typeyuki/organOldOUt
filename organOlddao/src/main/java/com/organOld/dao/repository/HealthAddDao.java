package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.HealthAdd;

public interface HealthAddDao extends BaseDao<HealthAdd,Number> {
    void delByOldmanId(int id);
}
