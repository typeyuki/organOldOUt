package com.organOld.oService.service;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.ListRequest;
import com.organOld.oService.model.AutoValModel;

import java.util.List;

public interface ListService {
    Conse getOrgAutoValue(ListRequest listRequest);

    Conse getOrganInfo(int organId);

    //List<AutoValModel> getAutoValByFir(ListRequest listRequest);
}
