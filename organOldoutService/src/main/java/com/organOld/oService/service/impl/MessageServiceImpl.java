package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.MessageOut;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.MessageDao;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.repository.out.MessageOutDao;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.MessageModel;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.MessageService;
import com.organOld.oService.wrapper.MessageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    UserDao userDao;
    @Autowired
    MessageOutDao messageOutDao;
    @Autowired
    CardDao cardDao;


    @Override
    @Transactional
    public Conse saveMessage(MessageRequest messageRequest){
        Integer userId = comService.getOldsIdBySession();
        if(userId == 0 || userId == null)
            userId = messageRequest.getOldmanId();
        if(userId == 0 || userId.equals(null))
            throw new ServiceException("请先登录");
        List<Integer> userIds = userDao.getRoleUserIds();
        for(Integer user_id:userIds){
        Message message = messageWrapper.unwrap(messageRequest);
        message.setUserId(user_id);
        messageDao.save(message);
        }
        return new Conse(true);
    }

    @Override
    @Transactional
    public void saveCartMessage(MessageRequest messageRequest){
        Card user = oldUserDao.getById(messageRequest.getOldmanId());
        Message message = messageWrapper.unwrap(messageRequest);
        message.setUserId(userDao.getUserId(messageRequest.getOrganId()));
        message.setIsRead(0);
        Organ organ = new Organ();
        organ.setId(messageRequest.getOrganId());
        message.setOrgan(organ);
        messageDao.saveBookMessage(message);
    }

    @Override
    public Conse getMessage(MessageRequest messageRequest){
        Integer userId = messageRequest.getOldmanId();
        if(userId == 0 || userId == null)
            userId = messageRequest.getOldmanId();
        if(userId == 0 || userId.equals(null))
            throw new ServiceException("请先登录");
        Card user = cardDao.getByOldmanId(messageRequest.getOldmanId());
        String cardId = user.getUsername();
        List<MessageModel> messageModels = messageOutDao.getMessage(cardId).stream().map(messageWrapper::wrapMes).collect(Collectors.toList());
        if(messageModels == null)
            throw new ServiceException("暂时没有通知");
        return new Conse(true,messageModels);
    }
}
