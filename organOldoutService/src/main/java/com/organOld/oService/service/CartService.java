package com.organOld.oService.service;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;

public interface CartService {
    Conse SaveInCart(CartRequest cartRequest);

    String getProductIds(int oldmanId, BTableRequest bTableRequest);

    String getProByOldmanId(int oldmanId, BTableRequest bTableRequest);

    void delByIds(String[] ids);
}
