package com.organOld.oService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.out.oldsUserDao;
import com.organOld.oService.constant.Constant;
import com.organOld.oService.contract.CardRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.UserModel;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.OldsUserService;
import com.organOld.oService.service.TokenMgrService;
import com.organOld.oService.tool.Cache;
import com.organOld.oService.wrapper.UserWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    TokenMgrService tokenMgrService;

    /**
     * 获取账户信息
     * @param oldmanId
     * @return
     */
    @Override
    public Conse getBySession(Integer oldmanId){
        Card user = null;
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            if(oldmanId != null && oldmanId != 0)
                userId = oldmanId;
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
        if(card == null)
            throw new ServiceException("账号不存在");
        if(cardRequest.getPassword().equals(card.getPassword())){
           String token = tokenMgrService.createJWT(card.getUsername(), Constant.JWT_ISS,tokenMgrService.generalSubject(card),Constant.JWT_TTL);
//           if(Cache.checkCacheName(card.getUsername()+""))
//               throw new ServiceException("该账号已登录！");
           Cache.put(token,card,Cache.CACHE_HOLD_TIME_24H);
           return new Conse(true,token);

        }

        else
            throw new ServiceException("账号或密码输入错误！");
    }
    @Override
    public Conse checkLogOut(HttpServletRequest request){
        String tokenStr = request.getParameter("token");
        if(Cache.checkCacheName(tokenStr)){
            Cache.remove(tokenStr);
            return new Conse(true,"退出成功");
        }
        else
            throw new ServiceException("您还未登录");


    }

}
