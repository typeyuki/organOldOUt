package com.organOld.dao.repository.out;

import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.MessageOut;
import com.organOld.dao.repository.BaseDao;
import sun.print.BackgroundLookupListener;

import java.util.List;

public interface MessageOutDao extends BaseDao<MessageOut,Number> {
   List<MessageOut> getMessage(String id);
}
