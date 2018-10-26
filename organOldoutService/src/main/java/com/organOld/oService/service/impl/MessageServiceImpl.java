package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.Message;
import com.organOld.dao.repository.MessageDao;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.MessageService;
import com.organOld.oService.wrapper.MessageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;
    @Autowired
    ComService comService;
    @Autowired
    MessageWrap messageWrapper;
    @Autowired
    oldsUserDao oldUserDao;

    @Override
    @Transactional
    public Conse saveMessage(MessageRequest messageRequest){
        Integer userId = comService.getOldsIdBySession();
        if(userId == 0 || userId == null)
            userId = messageRequest.getOldmanId();
        if(userId == 0 || userId.equals(null))
            throw new ServiceException("请先登录");
        Card user = oldUserDao.getById(userId);
        Message message = messageWrapper.unwrap(messageRequest);
        message.setUsername(user.getUsername());
        messageDao.save(message);
        return new Conse(true);
    }
}
