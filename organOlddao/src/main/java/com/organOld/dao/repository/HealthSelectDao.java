package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.HealthSelect;

/**
 * Created by netlab606 on 2018/7/16.
 */
public interface HealthSelectDao extends BaseDao<HealthSelect,Number>{
    Integer getFirTypeById(Integer id);
}
