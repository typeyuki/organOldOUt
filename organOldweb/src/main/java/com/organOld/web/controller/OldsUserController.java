package com.organOld.web.controller;

import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cardUser")
public class OldsUserController {
    @Autowired
    OldsUserService oldsUserService;

    @ResponseBody
    @RequestMapping(value = "/accountInfo",method = RequestMethod.GET)
    public Conse getAccount(){
        return oldsUserService.getBySession();
    }

    @ResponseBody
    @RequestMapping(value = "/changePwd",method = RequestMethod.GET)
    public Conse UpdatePwd(CardRequest cardRequest){
        return oldsUserService.updatePwd(cardRequest);
    }

}
