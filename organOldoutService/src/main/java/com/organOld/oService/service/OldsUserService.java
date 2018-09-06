package com.organOld.oService.service;

import com.organOld.dao.entity.Card;

public interface OldsUserService {
    Card getBySession();

    void updatePwd (Card oldUser);

    Card getByUsername (String name);

}
