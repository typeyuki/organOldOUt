package com.organOld.oService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.oService.contract.AutoValRequest;
import com.organOld.oService.model.AutoValModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by netlab606 on 2018/7/25.
 */
@Service
public class AutoValWrap implements Wrap<AutoValue,AutoValModel,AutoValRequest> {


    @Override
    public AutoValModel wrap(AutoValue autoValue) {
        AutoValModel autoValModel =new AutoValModel();
        BeanUtils.copyProperties(autoValue, autoValModel);
        return autoValModel;
    }

    @Override
    public AutoValue unwrap(AutoValRequest autoValRequest) {
        AutoValue autoValue=new AutoValue();
        BeanUtils.copyProperties(autoValRequest,autoValue);
        return autoValue;
    }
}
