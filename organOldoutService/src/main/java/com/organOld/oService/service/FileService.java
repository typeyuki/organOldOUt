package com.organOld.oService.service;

import com.organOld.oService.contract.*;
import com.organOld.oService.model.LabelInfoModel;
import com.organOld.oService.model.OldsHealthModel;
import com.organOld.oService.model.PersonalInfoModel;

import javax.xml.transform.Result;

public interface FileService  {

    PersonalInfoModel getPersonalInfo (int oldmanId);

    OldsHealthModel getOldmanHealth (int oldmanId);

    String getByCardPage (BTableRequest bTableRequest, CardLogsRequest cardLogsRequest);

    Conse getByLabel (int oldmanId);

    String getByLogPage(LogsRequest logsRequest,BTableRequest bTableRequest);

    Conse getOldsIntegral(int oldmanId);
}
