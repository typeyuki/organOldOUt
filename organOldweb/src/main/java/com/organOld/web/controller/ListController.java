package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.ListRequest;
import com.organOld.oService.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/list")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ListController {
    @Autowired
    ListService listService;
    @ResponseBody
    @RequestMapping(value="/getLabels",method = RequestMethod.GET)
    public Conse getSimpleOrganValue(ListRequest listRequest){
        return listService.getOrgAutoValue(listRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrganInfo",method = RequestMethod.GET)
    public Conse getOrganDetail(int organId){
        return listService.getOrganInfo(organId);
    }

}
