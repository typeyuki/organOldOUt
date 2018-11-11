package com.organOld.oService.wrapper;

import com.organOld.dao.entity.label.LabelMan;
import com.organOld.oService.model.LabelInfoModel;
import org.springframework.stereotype.Service;

@Service
public class LabelWrap {
    public LabelInfoModel wrap(LabelMan labelMan) {
        LabelInfoModel labelInfoModel = new LabelInfoModel();
        labelInfoModel.setLabelName(labelMan.getLabelName());
        if(labelMan.getIsImplement()==0)
            labelInfoModel.setIsImplement("未落实");
        if(labelMan.getIsImplement()==1)
            labelInfoModel.setIsImplement("落实");
        return labelInfoModel;
    }
}
