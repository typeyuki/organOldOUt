package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OldsUserServiceImpl implements OldsUserService {
    @Autowired
    ComService comService;
    @Autowired
    oldsUserDao oldUserDao;

    /**
     * 获取账户信息
     * @param oldmanId
     * @return
     */
    @Override
    public Conse getBySession(String oldmanId){
        Card user = null;
        if(oldmanId != null)
            user = oldUserDao.getById(Integer.parseInt(oldmanId));
        else {
            Integer userId = comService.getOldsIdBySession();
            if (userId == null || userId == 0)
                user = oldUserDao.getByUsername(comService.getUserNameBySession());
            else
                user = oldUserDao.getById(userId);
        }
        if(user == null){
            throw new ServiceException("找不到用户信息,请登录");
        }
        return new Conse(true,user);
    }

    /**
     * 修改密码
     * @param cardRequest
     * @return
     */
    @Override
    public Conse updatePwd(CardRequest cardRequest){
        boolean f = comService.PwdComparedBySession(cardRequest.getOldPwd());
        if(f){
            Integer userId = comService.getOldsIdBySession();
            if (userId == null || userId == 0)
                throw new ServiceException("请登录");
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String newPwd = bCryptPasswordEncoder.encode(cardRequest.getPassword());
            oldUserDao.updateProp("password",newPwd, userId);
            return new Conse(true);
        }
        else
            throw new ServiceException("密码错误");
    }

    @Override
    public Card getByUsername (String username){
        Card user = oldUserDao.getByUsername(username);
        return user;
    }

}
