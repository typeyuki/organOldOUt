package com.organOld.web.controller;

import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/organOut")
public class LoginController {


    @ResponseBody
    @RequestMapping("/login",method = RequestMethod.GET)
    public Conse login(HttpServletRequest request, HttpServletResponse response, CardRequest cardRequest){

    }

}
