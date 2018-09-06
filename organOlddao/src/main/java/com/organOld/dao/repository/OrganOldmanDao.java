package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OrganOldmanDao extends BaseDao<OrganOldman,Integer>{
    void delByOid(int id);

    void delByOrganId(int organId);

    List<Oldman> getByOrganId(Integer organId);

    int getNumByOldmanId(int oldmanId);

    List<OrganOldman> getManByPage(Page<OrganOldman> page);

    Long getManSizeByPage(Page<OrganOldman> page);


    List<OrganOldman> getDelOldmanIdsByOrganOldmanIds(Integer[] id);

    Long getNySize(String ny);

    void delByOrganOldman(OrganOldman organOldman);

    long getOrganOldmanOidSize(String ny);

    List<OrganOldman> getOrganOldmanOidByRound(@Param("round") long round, @Param("current") long current,@Param("ny") String prevNy);

    void delByOrganIds(String[] ids);
}
