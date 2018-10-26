package com.organOld.oService.wrapper;

import com.organOld.dao.entity.Card;
import com.organOld.oService.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserWrap implements Wrap<Card,UserModel,Number>{
    @Override
    public Card unwrap(Number num){
        return null;
    }

    @Override
    public UserModel wrap(Card card){
        UserModel userModel = new UserModel();
        userModel.setPassword(card.getPassword());
        userModel.setUsername(card.getUsername());
        return userModel;
    }
}
