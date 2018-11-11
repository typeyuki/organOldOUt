package com.organOld.web.controller;

import com.organOld.dao.entity.Message;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    ComService comService;

    @ResponseBody
    @RequestMapping(value = "/saveMessage",method = RequestMethod.GET)
    public Conse saveUserMessage(HttpServletRequest request, MessageRequest messageRequest){
        messageRequest.setOldmanId(comService.getUserByToken(request));
        return messageService.saveMessage(messageRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getMessage",method = RequestMethod.GET)
    public Conse getCardMessage(HttpServletRequest request, MessageRequest messageRequest){
        messageRequest.setOldmanId(comService.getUserByToken(request));
        return messageService.getMessage(messageRequest);
    }
}
