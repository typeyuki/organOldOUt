package com.organOld.web.security;


import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.SysUser;
import com.organOld.oService.service.OldsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by netlab606 on 2018/4/8.
 */
public class DefaultUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserCache userCache;
    @Autowired
    private OldsUserService oldsUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//        User user = (User) this.userCache.getUserFromCache(username);

//        if(user == null){
            Card user = oldsUserService.getByUsername(username);
            if(user == null)
                throw new UsernameNotFoundException("UserDetailsService.userNotFound");
            //得到用户的权限
//        }

//        this.userCache.putUserInCache(user);
        return user;
    }
}
