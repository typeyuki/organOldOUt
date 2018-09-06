package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OldmanKeyDao extends BaseDao<Oldman,Integer>{
    List<OldmanKey> getAllOldmanKey();

    List<OldmanKey> getOldmanKeyByRound(@Param("round") long round, @Param("current") long current);
}
