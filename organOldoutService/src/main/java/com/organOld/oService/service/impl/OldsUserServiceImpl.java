package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class OldsUserServiceImpl implements OldsUserService {
    @Autowired
    ComService comService;
    @Autowired
    oldsUserDao oldUserDao;
    @Override
    public Card getBySession(){
        Card user = null;
        Integer userId = comService.getIdBySession();
        if(userId == null || userId == 0){
            user = oldUserDao.getByUsername(comService.getUserNameBySession());
        }else{
            user = oldUserDao.getById(userId);
        }
        return user;
    }
    @Override
    public void updatePwd(Card oldUser){
        oldUserDao.updateProp("password",oldUser.getPassword(),oldUser.getOldmanId());
    }

    @Override
    public Card getByUsername (String username){
        Card user = oldUserDao.getByUsername(username);
        return user;
    }

}
