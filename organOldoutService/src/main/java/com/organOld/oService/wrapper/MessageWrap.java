package com.organOld.oService.wrapper;

import com.organOld.dao.entity.Message;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.Pattern;
import com.organOld.oService.service.ComService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageWrap implements Wrap<Message,AutoValModel,MessageRequest> {
    @Autowired
    ComService comService;
    @Override
    public AutoValModel wrap(Message message){
        return null;
    }
    @Override
    public Message unwrap(MessageRequest messageRequest){
        Message message = new Message();
        message.setContent(messageRequest.getContent());
        message.setType(2);
        message.setUserId(comService.getIdBySession());
        return message;
    }


}
