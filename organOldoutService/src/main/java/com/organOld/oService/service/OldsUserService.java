package com.organOld.oService.service;

import com.organOld.dao.entity.Card;
import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;

public interface OldsUserService {
    Conse getBySession(String oldmanId);

    Conse updatePwd (CardRequest cardRequest);

    Card getByUsername (String name);

}
