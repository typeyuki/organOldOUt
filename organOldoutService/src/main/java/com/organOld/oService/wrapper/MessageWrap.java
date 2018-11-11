package com.organOld.oService.wrapper;

import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.MessageOut;
import com.organOld.oService.Tool;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.MessageModel;
import com.organOld.oService.model.Pattern;
import com.organOld.oService.service.ComService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        message.setType(messageRequest.getType());
        return message;
    }

    public MessageModel wrapMes(MessageOut message){
        MessageModel messageModel = new MessageModel();
        messageModel.setContent(message.getContent());
        messageModel.setCardId(message.getCardId());
        messageModel.setTime(Tool.dateToString(message.getTime(), TimeConst.DATA_FORMAT_YMDHMS));
        return messageModel;
    }


}
