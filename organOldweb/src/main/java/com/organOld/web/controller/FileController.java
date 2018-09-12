package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @ResponseBody
    @RequestMapping(value="/getById", method = RequestMethod.GET)
        public Conse getById (@PathVariable int id){return new Conse(true,fileService.getPersonalInfo(id)); }

    @ResponseBody
    @RequestMapping(value="/getHealthById", method = RequestMethod.GET)
        public Conse getHealthById (@PathVariable int id){
            return new Conse(true,fileService.getOldmanHealth(id));
    }

    @ResponseBody
    @RequestMapping(value = "/record",method = RequestMethod.POST)
        public String data0(BTableRequest bTableRequest, CardLogsRequest cardLogsRequest){
            return fileService.getByCardPage(bTableRequest,cardLogsRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getLabelById", method = RequestMethod.GET)
        public Conse getLabelById (@PathVariable int id){
            return fileService.getByLabel(id);
    }
}
