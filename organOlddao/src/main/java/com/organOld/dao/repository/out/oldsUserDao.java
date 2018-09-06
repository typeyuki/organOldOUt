package com.organOld.dao.repository.out;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.repository.BaseDao;

import java.util.List;

public interface oldsUserDao extends BaseDao<Card,Number> {
   Card getByUsername (String cid);

   List<SysAuthority> getSysAuthirtiesByUsername (String cid);

   Integer getOldsIdByUsername (String cid);

   Card checkUserLogin ();
}
