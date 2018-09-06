package com.organOld.oService.wrapper;

import com.organOld.dao.entity.label.LabelMan;
import com.organOld.oService.model.LabelInfoModel;
import org.springframework.stereotype.Service;

@Service
public class LabelWrap {
    public LabelInfoModel wrap(LabelMan labelMan) {
        LabelInfoModel labelInfoModel = new LabelInfoModel();
        labelInfoModel.setLabelName(labelMan.getLabelName());
        labelInfoModel.setIsImplement(labelMan.getIsImplement()==0?"已落实":"未落实");
        return labelInfoModel;
    }
}
