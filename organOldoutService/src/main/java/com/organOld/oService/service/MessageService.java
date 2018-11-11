package com.organOld.oService.service;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;

public interface MessageService {
    Conse saveMessage(MessageRequest messageRequest);

    void saveCartMessage(MessageRequest messageRequest);

    Conse getMessage(MessageRequest messageRequest);
}
