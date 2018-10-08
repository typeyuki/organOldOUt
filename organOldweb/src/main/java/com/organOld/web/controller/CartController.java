package com.organOld.web.controller;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @ResponseBody
    @RequestMapping(value="/save",method= RequestMethod.GET)
    public Conse saveCart(CartRequest cartRequest){
        return cartService.SaveInCart(cartRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getCartInfo",method = RequestMethod.POST)
    public String getCartProducts(BTableRequest bTableRequest){
        return cartService.getProByOldmanId(bTableRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/saveInBook",method = RequestMethod.POST)
    public Conse saveBook(){
        return cartService.SaveInBook();
    }
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Conse DeleteGoods(String[] ids){
        return cartService.delByIds(ids);
    }
}
