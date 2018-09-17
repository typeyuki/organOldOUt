package com.organOld.oService.service.impl;

import com.organOld.dao.entity.product.ProductCart;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.out.CartDao;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.service.CartService;
import com.organOld.oService.wrapper.CartWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    CartWrap cartWrapper;
    @Override
    public Conse SaveInCart (CartRequest cartRequest){
        ProductCart productCart = cartWrapper.unwrap(cartRequest);
        cartDao.save(productCart);
        return new Conse(true);
    }
}
