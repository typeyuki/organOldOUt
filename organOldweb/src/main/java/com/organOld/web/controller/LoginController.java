package com.organOld.web.controller;

import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/identify")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
     @Autowired
    OldsUserService oldsUserService;
     @Autowired
    ComService comService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Conse login( CardRequest cardRequest){
        return oldsUserService.checkLogin(cardRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Conse LogOut(CardRequest cardRequest){
        return oldsUserService.checkLogOut(cardRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/checkToken",method = RequestMethod.GET)
    public Conse checkToken(HttpServletRequest request){
        Integer oldmanId = comService.getUserByToken(request);
        if(oldmanId == 0)
            throw new ServiceException("请先登录");
        else
            return new Conse(true,"您已经登录");
    }

}
