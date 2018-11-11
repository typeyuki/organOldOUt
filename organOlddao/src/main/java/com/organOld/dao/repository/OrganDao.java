package com.organOld.dao.repository;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.Organ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface OrganDao extends BaseDao<Organ,Integer>{
    List<Organ> getSimpleByType(@Param("type") Integer type,@Param("organId") Integer organId);

    String getNameById(int id);

    Organ getByUsername(String username);

    Organ getAuthById(int organId);

    Organ getSimpleById(int organId);

    Organ getOrganDById(Integer organId);

    List<Organ> getRoleOrgan(@Param("type") int type, @Param("typeIndex") int typeIndex);

    List<Organ> getByType(int type);

    List<Organ> getByTypes(List<Integer> typeIds);

    List<Organ> getByIds(List<String> ids);

    List<Organ> getByFirType(int firType);

    Integer getIdByName(String name);

    List<Organ> getAll();

    void updateAuth(@Param("id") Integer organId,@Param("consume") Integer authConsume, @Param("product") Integer authProduct,@Param("sign") Integer authSign, @Param("info") Integer authQueryInfo,@Param("integral") Integer authQueryIntegral);

    List<Organ> getALLNotInFirType(int firType);

    Map<String,Long> getOrganNum();

    Long getNumByType(@Param("type") int type,@Param("organId") Integer organId);

    Long getAllSize();

    List<Organ> getOrganTypeMap();

    List<Organ> getAutoValueByIds(List<Integer> ids);

    List<Organ> getJwByDis(Integer disId);
}
