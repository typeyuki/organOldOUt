package com.organOld.oService.service;

import com.organOld.dao.entity.Card;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;

public interface TokenMgrService {
    SecretKey generalKey();

    String createJWT(String id,String iss,String subject,long ttlMillis) ;

    Claims parseJWT(String jwt);

    String generalSubject(Card sub);
}
