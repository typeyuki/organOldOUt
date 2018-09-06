package com.organOld.dao.repository;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T extends DBEntity,ID extends Number> {
    void save(T entity);
    void saveAll(List<T> list);
    void delById(ID id);
    T getById(ID id);
    List<T> getByPage(Page page);
    Long getSizeByPage(Page page);
    void updateById(T entity);
    void updateByIds(List<T> list);

    void updateProp(@Param("prop") String prop, @Param("value") String s,@Param("id") int id);
    void updateProps(@Param("prop") String prop, @Param("value") String s,@Param("ids") String[] ids);

    void delByIds(ID[] ids);
}
