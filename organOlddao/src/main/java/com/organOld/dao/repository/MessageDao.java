package com.organOld.dao.repository;

import com.organOld.dao.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao extends BaseDao<Message,Number> {
    void saveAllMessage(@Param("userIds") List<Integer> userIds,@Param("message") Message message);

    void saveBookMessage(Message message);

    void readByUsername(String username);

    int getNoReadNumByUsername(String username);
}
