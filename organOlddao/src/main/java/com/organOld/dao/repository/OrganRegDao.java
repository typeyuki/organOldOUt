package com.organOld.dao.repository;

import com.organOld.dao.entity.organ.OrganReg;

public interface OrganRegDao extends BaseDao<OrganReg,Number>{
    OrganReg getByOrganId(int organId);
}
