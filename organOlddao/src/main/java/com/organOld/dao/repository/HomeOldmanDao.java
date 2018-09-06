package com.organOld.dao.repository;


import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface HomeOldmanDao extends BaseDao<HomeOldman,Integer>{
    void delByOid(int id);

    void delByJwId(Integer jwId);

    void delAll();


    List<HomeOldman> getManAllByPage(Page<HomeOldman> page);

    Long getManAllSizeByPage(Page<HomeOldman> page);

    List<Integer> getDelOldmanIdsByHomeOldmanIds(Integer[] id);

    long getHomeOldmanOidSize(String ny);

    List<Integer> getOidByRound(@Param("round") long round, @Param("current") long current,@Param("ny") String prevNy);

    void delByNy(String ny);
}
