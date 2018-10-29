package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.LogsRequest;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/file")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    ComService comService;

    @ResponseBody
    @RequestMapping(value="/{id}/getById", method = RequestMethod.GET)
        public Conse getById (HttpServletRequest request,@PathVariable("id") int id){
        if(id == 0)
        id = comService.getUserByToken(request);
        return new Conse(true,fileService.getPersonalInfo(id)); }

    @ResponseBody
    @RequestMapping(value="/{id}/getHealthById", method = RequestMethod.GET)
        public Conse getHealthById (HttpServletRequest request,@PathVariable("id") int id){
        if(id == 0)
            id = comService.getUserByToken(request);
            return new Conse(true,fileService.getOldmanHealth(id));
    }

    @ResponseBody
    @RequestMapping(value = "/record",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
        public String data0(HttpServletRequest request, BTableRequest bTableRequest, CardLogsRequest cardLogsRequest){
        if(cardLogsRequest.getOldmanId() == null)
        cardLogsRequest.setOldmanId(comService.getUserByToken(request));
            return fileService.getByCardPage(bTableRequest,cardLogsRequest);
    }


    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getData(HttpServletRequest request, BTableRequest bTableRequest, LogsRequest logsRequest){
        if(logsRequest.getOldmanId() == null)
        logsRequest.setOldmanId(comService.getUserByToken(request));
           return fileService.getByLogPage(logsRequest,bTableRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/getIntegral",method = RequestMethod.GET)
    public Conse getIntegral(HttpServletRequest request, Integer id){
        if (id==0||id==null)
        id = comService.getUserByToken(request);
        return fileService.getOldsIntegral(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/getLabelById", method = RequestMethod.GET)
        public Conse getLabelById (@PathVariable("id") int id){
            return fileService.getByLabel(id);
    }
}
