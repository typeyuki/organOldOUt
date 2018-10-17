package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/organ")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrganController {
    @Autowired
    OrganService organService;
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public ModelAndView reg(OrganRegRequest organRegRequest, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("organ/reg_return");
        Conse result=organService.reg(organRegRequest,request);
        mv.addObject("result",result);
        return mv;
    }

//    @RequestMapping(value = "/organReg",method = RequestMethod.GET)
//    public ModelAndView organReg(){
//        ModelAndView mv=new ModelAndView("organ/organ_reg");
//        mv.addObject("info",organService.getRegInfo());
//        return mv;
//    }
}
