package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {
    @Autowired
    CartService cartService;
    @ResponseBody
    @RequestMapping(value="/save",method= RequestMethod.GET)
    public Conse saveCart(CartRequest cartRequest){
        return cartService.SaveInCart(cartRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getCartInfo",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getCartProducts(BTableRequest bTableRequest,Integer oldmanId){
        return cartService.getProByOldmanId(bTableRequest,oldmanId);
    }

    @ResponseBody
    @RequestMapping(value = "/saveInBook",method = RequestMethod.GET)
    public Conse saveBook(Integer oldmanId){
        return cartService.SaveInBook(oldmanId);
    }
    @ResponseBody
    @RequestMapping( value = "/delete",method = RequestMethod.GET)
    public Conse DeleteGoods(String[] ids){
        return cartService.delByIds(ids);
    }
}
