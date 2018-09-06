package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.HealthSelectMan;

import java.util.List;

public interface HealthSelectManDao extends BaseDao<HealthSelectMan,Number> {
    void delByOldmanIds(List<Integer> existOldmanIds);

    void delByOldmanId(int oldmanId);
}
