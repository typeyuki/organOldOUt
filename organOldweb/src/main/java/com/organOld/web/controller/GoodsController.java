package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.contract.ProductBookRequest;
import com.organOld.oService.service.GoodsService;
import com.organOld.oService.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    ProductTypeService productTypeService;
    @ResponseBody
    @RequestMapping(value="/getProductByPage",method = RequestMethod.GET)
    public Conse getProductByPage(Integer iDisplay, GoodsRequest goodsRequest){
        return goodsService.getByProductPage(goodsRequest,iDisplay);
    }

    @ResponseBody
    @RequestMapping(value="/getByOrganId",method = RequestMethod.GET)
    public Conse getByOrganId(Integer iDisplay,GoodsRequest goodsRequest){
        return goodsService.getProductByOrganId(goodsRequest,iDisplay);
    }
    @ResponseBody
    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public Conse getAll(){
        return goodsService.getAllProduct();
    }

    @ResponseBody
    @RequestMapping(value = "/getOrganByGood",method = RequestMethod.GET)
    public Conse getOrgans(Integer type){return goodsService.getOrganByProduct(type);}

    @ResponseBody
    @RequestMapping(value="/getTypes",method = RequestMethod.GET)
    public Conse getTypeByParent(){
        return productTypeService.getProductType();
    }

    @ResponseBody
    @RequestMapping(value = "/book/data",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String data(ProductBookRequest productBookRequest, BTableRequest bTableRequest){
        return goodsService.getBookByPage(productBookRequest,bTableRequest);
    }

}
