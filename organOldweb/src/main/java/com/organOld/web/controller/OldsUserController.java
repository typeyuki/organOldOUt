package com.organOld.web.controller;

import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cardUser")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OldsUserController {
    @Autowired
    OldsUserService oldsUserService;
    @Autowired
    ComService comService;

    @ResponseBody
    @RequestMapping(value = "/accountInfo",method = RequestMethod.GET)
    public Conse getAccount(HttpServletRequest request,Integer oldmanId){
            oldmanId = comService.getUserByToken(request);
        return oldsUserService.getBySession(oldmanId);
    }

    @ResponseBody
    @RequestMapping(value = "/changePwd",method = RequestMethod.GET)
    public Conse UpdatePwd(HttpServletRequest request,CardRequest cardRequest){
            cardRequest.setOldmanId(comService.getUserByToken(request).toString());
        return oldsUserService.updatePwd(cardRequest);
    }

}
