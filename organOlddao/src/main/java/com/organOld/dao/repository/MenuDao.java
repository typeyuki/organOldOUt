package com.organOld.dao.repository;



import com.organOld.dao.util.MenuTree;

import java.util.List;

/**
 * Created by netlab606 on 2018/3/29.
 */
public interface MenuDao {
    List<MenuTree> getAllMenuTree();

    List<MenuTree> getMenuTreeByAuthentications(List<String> authorities);
}
