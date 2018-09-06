package com.organOld.dao.repository;

import com.organOld.dao.entity.label.LabelSec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/7/13.
 */
public interface LabelSecDao extends BaseDao<LabelSec,Number> {
    List<LabelSec> getByFirType(@Param("type") int firType);
}
