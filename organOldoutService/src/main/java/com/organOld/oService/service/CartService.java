package com.organOld.oService.service;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;

public interface CartService {
    Conse SaveInCart(CartRequest cartRequest);

    String getProductIds(BTableRequest bTableRequest);

    String getProByOldmanId(BTableRequest bTableRequest);

    Conse delByIds(String[] ids);

    Conse SaveInBook();
}
