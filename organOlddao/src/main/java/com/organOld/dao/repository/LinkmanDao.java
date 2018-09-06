package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Linkman;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface LinkmanDao extends BaseDao<Linkman,Integer>{
    void delByOid(int id);

    void updateByOldmanIds(List<Linkman> linkmanList_update);

    void updateByOldmanId(Linkman linkman);

    Linkman getByOldmanId(int id);
}
