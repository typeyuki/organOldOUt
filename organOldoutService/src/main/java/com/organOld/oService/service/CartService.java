package com.organOld.oService.service;

import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;

public interface CartService {
    Conse SaveInCart(CartRequest cartRequest);
}
