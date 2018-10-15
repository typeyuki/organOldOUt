package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @ResponseBody
    @RequestMapping(value="/getProductByPage",method = RequestMethod.GET)
    public String getProductByPage(BTableRequest bTableRequest, GoodsRequest goodsRequest){
        return goodsService.getByProductPage(goodsRequest,bTableRequest);
    }

    @ResponseBody
    @RequestMapping(value="/getByOrganId",method = RequestMethod.GET)
    public String getByOrganId(BTableRequest bTableRequest,GoodsRequest goodsRequest){
        return goodsService.getProductByOrganId(goodsRequest,bTableRequest);
    }
    @ResponseBody
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public String getAll(BTableRequest bTableRequest){
        return goodsService.getAllProduct(bTableRequest);
    }
    @ResponseBody
    @RequestMapping(value="getTypeByParent",method = RequestMethod.GET)
    public Conse getTypeByParent(int parent){
        return goodsService.getTypeByParent(parent);
    }

}
