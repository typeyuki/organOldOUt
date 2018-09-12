package com.organOld.oService.wrapper;


import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.HealthAdd;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.OldmanHealth;
import com.organOld.oService.enumModel.HealthsEnum;
import com.organOld.oService.model.OldsHealthModel;
import com.organOld.oService.service.AutoValService;
import com.organOld.oService.contract.OldsHealthRequest;
import com.organOld.oService.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OldsHealthWrap implements Wrap<OldmanHealth,OldsHealthModel,OldsHealthRequest> {

    @Autowired
    ComService comService;
    @Autowired
    AutoValService autoValService;

    /**
     * 用于填充 auto_value 的数据
     */
    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();

    @Override
    public OldsHealthModel wrap(OldmanHealth oldmanHealth) {

        OldsHealthModel oldsHealthModel =new OldsHealthModel();
        oldsHealthModel.setId(oldmanHealth.getId()+"");
        if(oldmanHealth.getOldman()!=null) {
            oldsHealthModel.setOldmanId(oldmanHealth.getOldman().getId());
            oldsHealthModel.setName(oldmanHealth.getOldman().getName());
        }
        oldsHealthModel.setBloodType(oldmanHealth.getBloodType());
        //TODO  选取所有表格中最新的一个时间  暂时还没实现
       // oldsHealthModel.setTime(Tool.dateToString(oldmanHealth.getTime(), TimeConst.DATA_FORMAT_YMD));

        if(oldmanHealth.getHealthAdd()!=null && oldmanHealth.getHealthAdd().size()>0){
            for(HealthAdd healthAdd:oldmanHealth.getHealthAdd()){
                HealthAdd add=new HealthAdd();
                //add.setId(healthAdd.getId());
                add.setDesc(healthAdd.getDesc());
                add.setTime(healthAdd.getTime());
                if(healthAdd.getType()== HealthsEnum.EXZL.getIndex()) {
                    oldsHealthModel.getCancer().add(add);
                }else if(healthAdd.getType()== HealthsEnum.GZ.getIndex()){
                    oldsHealthModel.getBroken().add(add);
                }else{
                    oldsHealthModel.getDisabled().add(add);
                }
            }
        }
        if(oldmanHealth.getHealthSelect()!=null && oldmanHealth.getHealthSelect().size()>0){
            for(HealthSelect healthSelect:oldmanHealth.getHealthSelect()){
                HealthSelect select=new HealthSelect();
                //select.setId(healthSelect.getId());
                select.setTime(healthSelect.getTime());
                select.setSecTypeName(healthSelect.getSecTypeName());
                if(healthSelect.getFirType()== HealthsEnum.MB.getIndex()) {
                    oldsHealthModel.getChronicDis().add(select);
                }else if(healthSelect.getFirType()== HealthsEnum.SN.getIndex()){
                    oldsHealthModel.getAbiliInfo().add(select);
                }else{
                    oldsHealthModel.getDrugAlley().add(select);
                }
            }
        }
        if(method.size()==0){
            method.add("Eyesight");
            method.add("Intelligence");
        }
        if(map.size()==0){
            List<Integer> autoIds= comService.getAutoValueTypes("health_add");
            List<AutoValue> autoValueList= autoValService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        comService.fillAutoValue(oldmanHealth, oldsHealthModel,method,map);
        return oldsHealthModel;
    }

    @Override
    public OldmanHealth unwrap(OldsHealthRequest oldsHealthRequest) {

        return null;
    }
}
