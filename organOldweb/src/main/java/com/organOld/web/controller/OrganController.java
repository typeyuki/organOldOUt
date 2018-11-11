package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/organ")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrganController {
    @Autowired
    OrganService organService;
    @ResponseBody
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public Conse reg(OrganRegRequest organRegRequest, HttpServletRequest request, @RequestParam(value = "auth[]",required = false) String authArray[]){
        organRegRequest.setAuth(authArray);
        Conse result=organService.reg(organRegRequest,request);
        return result;
    }

//    @RequestMapping(value = "/organReg",method = RequestMethod.GET)
//    public ModelAndView organReg(){
//        ModelAndView mv=new ModelAndView("organ/organ_reg");
//        mv.addObject("info",organService.getRegInfo());
//        return mv;
//    }
}
