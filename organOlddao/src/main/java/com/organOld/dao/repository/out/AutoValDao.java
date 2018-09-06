package com.organOld.dao.repository.out;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.repository.BaseDao;

import java.util.List;

public interface AutoValDao extends BaseDao<AutoValue,Number> {
    List<AutoValue> getByIds(List<Integer> item);
}
