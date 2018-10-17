package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Message;
import com.organOld.dao.repository.MessageDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
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

    @Override
    @Transactional
    public Conse saveMessage(MessageRequest messageRequest){
        Message message = messageWrapper.unwrap(messageRequest);
        messageDao.save(message);
        return new Conse(true);
    }
}
