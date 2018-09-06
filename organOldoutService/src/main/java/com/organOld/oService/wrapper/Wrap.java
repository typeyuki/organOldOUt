package com.organOld.oService.wrapper;

import com.organOld.dao.entity.DBEntity;

//转换器  T：entity R：com.organOld.Service.model S：request
public interface Wrap<T extends DBEntity,R,S> {
    R wrap(T t); //数据库实体 转换为 模型
    T unwrap(S s);//前端request 转为为数据库实体
}
