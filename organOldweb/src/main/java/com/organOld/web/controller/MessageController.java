package com.organOld.web.controller;

import com.organOld.dao.entity.Message;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController {
    @Autowired
    MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/saveMessage",method = RequestMethod.GET)
    public Conse saveUserMessage(MessageRequest messageRequest){
        return messageService.saveMessage(messageRequest);
    }
}
