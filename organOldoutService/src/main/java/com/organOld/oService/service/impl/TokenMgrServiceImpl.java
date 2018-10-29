package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.oService.constant.Constant;
import com.organOld.oService.service.TokenMgrService;
import com.organOld.oService.tool.GsonUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Service
public class TokenMgrServiceImpl implements TokenMgrService{

   @Override
   public SecretKey generalKey() {
       try {
           //方式一：byte[] encodedKey = Base64.decode(Constant.JWT_SECERT); 引入com.sun.org.apache.xerces.internal.impl.dv.util.Base64
           //方式二：不管哪种方式最终得到一个byte[]类型的key就行
           byte[] encodedKey = Constant.JWT_SECERT.getBytes("UTF-8");
           SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
           return key;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }

   }
    @Override
    public String createJWT(String id,String iss, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuer(iss)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    @Override
    public Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    @Override
    public String generalSubject(Card sub){
        return GsonUtil.objectToJsonStr(sub);
    }

}
