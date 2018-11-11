package com.organOld.oService.wrapper;

import com.organOld.dao.entity.record.Record;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.CardLogsRequest;
import com.organOld.oService.contract.LogsRequest;
import com.organOld.oService.enumModel.LabelTypeEnum;
import com.organOld.oService.enumModel.LogsTypeEnum;
import com.organOld.oService.enumModel.SignPeopleTypeEnum;
import com.organOld.oService.model.LogsModel;
import com.organOld.oService.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class LogsWrap implements Wrap<Record,LogsModel,LogsRequest> {


    @Override
    public LogsModel wrap(Record record) {
        LogsModel recordModel=new LogsModel();
        recordModel.setId(record.getId());
        recordModel.setData(record.getData());
        recordModel.setOldman(record.getOldman());
        recordModel.setTime(Tool.dateToString(record.getTime(), TimeConst.DATA_FORMAT_YMDHMS));
        recordModel.setOrgan(record.getOrgan());
        recordModel.setType(LogsTypeEnum.getValue(record.getType()));
        recordModel.setOrder(record.getOrder());
        recordModel.setHdTime(record.getHdTime());
        recordModel.setNowData(record.getNowMoney()+"");
        if(record.getType()==2){
            recordModel.setHdName(record.getName());
            if(record.getHdType()!=0)
                recordModel.setHdType(LabelTypeEnum.getValue(record.getHdType()));
            if(record.getPeopleType()!=0)
                recordModel.setPeopleType(SignPeopleTypeEnum.getValue(record.getPeopleType()));
            if(record.getOrder()!=null) {
                switch (record.getOrder()) {
                    case "1":
                        recordModel.setSecType("日常签到");
                        break;
                    case "2":
                        recordModel.setSecType("活动签到");
                        break;
                }
            }
        }
        if(record.getType()==4){
            if(record.getOrder()!=null) {
                switch (record.getOrder()) {
                    case "1":
                        recordModel.setSecType("积分查询");
                        break;
                    case "2":
                        recordModel.setSecType("积分兑换");
                        recordModel.setIntegral(record.getData());
                        break;
                }
            }
        }
        if(record.getPrevMoney()!=null){
            if(record.getType()==9){
                recordModel.setMoneyChange(record.getPrevMoney().intValue()+"--->"+record.getNowMoney().intValue());
            }else{
                recordModel.setMoneyChange(record.getPrevMoney()+"--->"+record.getNowMoney());
            }
        }

        if(record.getType()==9){
            //积分记录
            if(record.getOrder()!=null) {
                String value="";
                switch (record.getOrder()) {
                    case "1":
                        value="消费";
                        break;
                    case "2":
                        value="日常签到增加";
                        break;
                    case "3":
                        value="活动签到增加";
                        break;
                    case "4":
                        value="积分兑换";
                        break;
                    case "5":
                        value="积分清零";
                        break;
                    case "6":
                        value="积分添加";
                        break;
                    case "7":
                        value="积分扣除";
                        break;

                }
                recordModel.setOrder(value);
            }

        }
        return recordModel;
    }

    @Override
    public Record unwrap(LogsRequest logsRequest) {
        Record record=new Record();
        if (logsRequest.getOrder() != null)
        record.setOrder((logsRequest.getOrder()+""));
        BeanUtils.copyProperties(logsRequest,record);
        record.setStart(Tool.stringToDate(logsRequest.getStart()));
        record.setEnd(Tool.stringToDate(logsRequest.getEnd()));
        return record;
    }

    public Record unwrapCard(CardLogsRequest cardLogsRequest) {
        Record record=new Record();
        record.setOldmanId(cardLogsRequest.getOldmanId());
     //   record.setCardId(cardLogsRequest.getId());
        record.setStart(Tool.stringToDate(cardLogsRequest.getStart()));
        record.setEnd(Tool.stringToDate(cardLogsRequest.getEnd()));
        record.setType(cardLogsRequest.getType());
        return record;
    }
}
