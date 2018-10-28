package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.UserModel;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import com.organOld.oService.wrapper.UserWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OldsUserServiceImpl implements OldsUserService {
    @Autowired
    ComService comService;
    @Autowired
    oldsUserDao oldUserDao;
    @Autowired
    UserWrap userWrapper;
    @Autowired
    CardDao cardDao;

    /**
     * 获取账户信息
     * @param oldmanId
     * @return
     */
    @Override
    public Conse getBySession(String oldmanId){
        Card user = null;
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            if(oldmanId != null && !oldmanId.equals(""))
                userId = Integer.parseInt(oldmanId);
            else
                throw new ServiceException("找不到用户信息,请登录");
//            if (userId == null || userId == 0)
//                user = oldUserDao.getByUsername(comService.getUserNameBySession());
//            else
//                user = oldUserDao.getById(userId);
        user = oldUserDao.getById(userId);
        UserModel userModel = userWrapper.wrap(user);
        return new Conse(true,userModel);
    }

    /**
     * 修改密码
     * @param cardRequest
     * @return
     */
    @Override
    @Transactional
    public Conse updatePwd(CardRequest cardRequest){
//        boolean f = comService.PwdComparedBySession(cardRequest.getOldPwd());
//        if(f){
            String oldmanId = cardRequest.getOldmanId();
            Integer userId = comService.getOldsIdBySession();
            if(userId == null || userId == 0)
                if(oldmanId != null && !oldmanId.equals(""))
                    userId = Integer.parseInt(oldmanId);
                else
                    throw new ServiceException("请先登录");
            //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            //String newPwd = bCryptPasswordEncoder.encode(cardRequest.getPassword());
            Card user = oldUserDao.getById(userId);
            if(cardRequest.getOldPwd().equals(user.getPassword()))
                if(cardRequest.getPassword().equals(user.getPassword()))
                    throw new ServiceException("新密码与原始密码相同！");
                else
                    oldUserDao.updateProp("password",cardRequest.getPassword(), user.getUsername());
            else
                throw new ServiceException("密码错误");
            return new Conse(true);
//        }

    }

    @Override
    public Card getByUsername (String username){
        Card user = oldUserDao.getByUsername(username);
        return user;
    }

    @Override
    public Conse checkLogin(CardRequest cardRequest){
        Card card = cardDao.getByCid(cardRequest.getUsername());
        if(cardRequest.getPassword().equals(card.getPassword()))
            return new Conse(true);
    }

}
