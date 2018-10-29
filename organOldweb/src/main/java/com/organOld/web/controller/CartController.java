package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.CartService;
import com.organOld.oService.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ComService comService;
    @ResponseBody
    @RequestMapping(value="/save",method= RequestMethod.GET)
    public Conse saveCart(HttpServletRequest request, CartRequest cartRequest){
        if(cartRequest.getOldmanId() == null)
        cartRequest.setOldmanId(comService.getUserByToken(request));
        return cartService.SaveInCart(cartRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getCartInfo",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getCartProducts(HttpServletRequest request,BTableRequest bTableRequest,Integer oldmanId){
        if(oldmanId == null)
            oldmanId = comService.getUserByToken(request);
        return cartService.getProByOldmanId(bTableRequest,oldmanId);
    }

    @ResponseBody
    @RequestMapping(value = "/saveInBook",method = RequestMethod.GET)
    public Conse saveBook(HttpServletRequest request,Integer oldmanId){
        if(oldmanId == null)
            oldmanId = comService.getUserByToken(request);
        return cartService.SaveInBook(oldmanId);
    }
    @ResponseBody
    @RequestMapping( value = "/delete",method = RequestMethod.GET)
    public Conse DeleteGoods(String[] ids){
        return cartService.delByIds(ids);
    }
}
