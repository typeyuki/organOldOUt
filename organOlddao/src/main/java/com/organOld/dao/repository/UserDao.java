package com.organOld.dao.repository;


import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.entity.SysRole;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.organ.Organ;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by netlab606 on 2018/3/24.
 */
public interface UserDao extends BaseDao<SysUser,Number>{
    SysUser getByUsername(String username);

    List<SysAuthority> getSysAuthoritiesByUsername(String username);

    Integer getOrganIdByUsername(String username);

    void setUserRole(@Param("userId") int userId, @Param("roleId") int roleId);

    void setUserOrgan(@Param("userId")int userId,@Param("organId") int organId);

    List<SysRole> getAllRole();

    String getOrganTypeByUsername(String username);

    List<Integer> getJwUserId(@Param("organId") Integer organId);

    Organ ckeckOrganLogin(SysUser sysUser);

    void setDisableByOrganId(int organId);

    SysUser getByOrganId(Integer organId);
}
