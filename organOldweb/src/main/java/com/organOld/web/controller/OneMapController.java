package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OneMapController {
    @Autowired
    OrganService organService;

    @ResponseBody
    @RequestMapping(value = "/getTypes",method = RequestMethod.GET)
    public Conse getOrganTypes(){
        return organService.getOrganTypes();
    }

    @ResponseBody
    @RequestMapping(value = "/getDetails",method = RequestMethod.GET)
    public Conse getOrganDetails(Integer organId){
         return organService.getOrganInfo(organId);
    }

    @ResponseBody
    @RequestMapping(value = "/getJwTypes",method = RequestMethod.GET)
    public Conse getJwTypes(){
        return organService.getTypes();
    }

    @ResponseBody
    @RequestMapping(value = "/getLocation",method = RequestMethod.GET)
    public Conse getOrganLocation(){
        return organService.getOrganLocation();
    }

}
