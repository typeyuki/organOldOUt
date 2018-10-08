package com.organOld.oService.service;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OldmanRequest;

public interface OutVisualService {
    Conse  getNeiborComAndNum(OldmanRequest oldmanRequest, BTableRequest bTableRequest);
}
