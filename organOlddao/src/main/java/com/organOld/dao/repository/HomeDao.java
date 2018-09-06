package com.organOld.dao.repository;

import com.organOld.dao.entity.home.Home;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeDao extends BaseDao<Home,Number>{
    Integer getIdBySecType(@Param("name") String name,@Param("firType") int index);

    Object getByIdAndFirType(@Param("id") int id,@Param("firType") int firType);

    List<Home> getAll();
}
