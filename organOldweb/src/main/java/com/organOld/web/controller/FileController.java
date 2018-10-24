package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/file")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileController {
    @Autowired
    FileService fileService;

    @ResponseBody
    @RequestMapping(value="/{id}/getById", method = RequestMethod.GET)
        public Conse getById (@PathVariable("id") int id){
        return new Conse(true,fileService.getPersonalInfo(id)); }

    @ResponseBody
    @RequestMapping(value="/{id}/getHealthById", method = RequestMethod.GET)
        public Conse getHealthById (@PathVariable("id") int id){
            return new Conse(true,fileService.getOldmanHealth(id));
    }

    @ResponseBody
    @RequestMapping(value = "/record",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
        public String data0(BTableRequest bTableRequest, CardLogsRequest cardLogsRequest){
            return fileService.getByCardPage(bTableRequest,cardLogsRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/getLabelById", method = RequestMethod.GET)
        public Conse getLabelById (@PathVariable("id") int id){
            return fileService.getByLabel(id);
    }
}
