package com.organOld.dao.repository;


import com.organOld.dao.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.List;

/**
 * Created by netlab606 on 2018/4/17.
 */
public interface SystemDao {
    void importExcel(@Param("list") List temp, @Param("cType") String cType, @Param("pType") String pType);

    SysRole getRoleByUsername(String username);
}
