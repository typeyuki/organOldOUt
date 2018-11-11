package com.organOld.oService.service;

import com.organOld.dao.entity.Card;
import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.Conse;

import javax.servlet.http.HttpServletRequest;

public interface OldsUserService {
    Conse getBySession(Integer oldmanId);

    Conse updatePwd (CardRequest cardRequest);

    Card getByUsername (String name);

    Conse checkLogin(CardRequest cardRequest);

    Conse checkLogOut(HttpServletRequest request);

}
