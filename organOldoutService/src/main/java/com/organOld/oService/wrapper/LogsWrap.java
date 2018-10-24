package com.organOld.oService.wrapper;

import com.organOld.dao.entity.record.Record;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.LogsRequest;
import com.organOld.oService.enumModel.LogsTypeEnum;
import com.organOld.oService.model.LogsModel;
import com.organOld.oService.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class LogsWrap implements Wrap<Record,LogsModel,LogsRequest> {


    @Override
    public LogsModel wrap(Record record) {
        LogsModel logsModel =new LogsModel();
        if(record != null) {
            logsModel.setId(record.getId());
            logsModel.setData(record.getData());
            //logsModel.setOldman(record.getOldman());
            logsModel.setTime(Tool.dateToString(record.getTime(), TimeConst.DATA_FORMAT_YMDHMS));
            logsModel.setOrgan(record.getOrgan());
            logsModel.setType(LogsTypeEnum.getValue(record.getType()));
            logsModel.setOrder(record.getOrder());
            logsModel.setChangeDetail(record.getPrevMoney()-record.getNowMoney());
            if (record.getPrevMoney() != null) {
                if (record.getType() == 9) {
                    logsModel.setMoneyChange(record.getPrevMoney().intValue() + "--->" + record.getNowMoney().intValue());
                } else {
                    logsModel.setMoneyChange(record.getPrevMoney() + "--->" + record.getNowMoney());
                }
            }

            if (record.getType() == 9) {
                //积分记录
                logsModel.setOrder(record.getOrder().equals("1") ? "消费" : "签到");
            }
        }
        return logsModel;
    }

    @Override
    public Record unwrap(LogsRequest logsRequest) {
        Record record=new Record();
        BeanUtils.copyProperties(logsRequest,record);
        record.setStart(Tool.stringToDate(logsRequest.getStart()));
        record.setEnd(Tool.stringToDate(logsRequest.getEnd()));
        return record;
    }

    public Record unwrapCard(CardLogsRequest cardLogsRequest) {
        Record record=new Record();
        record.setCardId(cardLogsRequest.getId());
        record.setOldmanId(cardLogsRequest.getOldmanId());
        record.setStart(Tool.stringToDate(cardLogsRequest.getStart()));
        record.setEnd(Tool.stringToDate(cardLogsRequest.getEnd()));
        record.setType(cardLogsRequest.getType());
        return record;
    }
}
