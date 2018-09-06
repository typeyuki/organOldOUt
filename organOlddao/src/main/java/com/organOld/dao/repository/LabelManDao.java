package com.organOld.dao.repository;

import com.organOld.dao.entity.label.LabelMan;
import org.apache.ibatis.annotations.Param;
import com.organOld.dao.entity.label.LabelManImplNum;

/**
 * Created by netlab606 on 2018/7/8.
 */
public interface LabelManDao extends BaseDao<LabelMan,Number> {
    void implement(LabelMan labelMan);

    LabelManImplNum getLabelManImplNum(@Param("organId") int organId,@Param("labelId") Integer labelId);

    void delByLabelIds(Integer[] id);

    void delByOldmanIds(@Param("oldmanIds") Integer[] id,@Param("labelId") int labelId);
}
