package com.organOld.oService.service;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;

import javax.servlet.http.HttpServletRequest;

public interface OrganService {
    Conse reg(OrganRegRequest organRegRequest, HttpServletRequest request);

    Conse getOrganTypes();

    Conse getOrganInfo(Integer organId);

    Conse getTypes();

    Conse getOrganLocation();


}
