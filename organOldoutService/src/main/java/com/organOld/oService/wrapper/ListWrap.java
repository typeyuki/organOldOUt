package com.organOld.oService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.OrganDao;
import com.organOld.oService.contract.ListRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.OrganModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ListWrap implements Wrap<Organ,AutoValModel,ListRequest> {
    @Autowired
    OrganDao organDao;
    @Override
    public AutoValModel wrap(Organ organ){
        AutoValModel autoValModel = new AutoValModel();
        autoValModel.setId(organ.getId());
        autoValModel.setValue(organ.getName());
        return autoValModel;
    }

    @Override
    public Organ unwrap(ListRequest listRequest){
        return null;
    }

    public List<Integer> unwarpList(ListRequest listRequest){
        List<Integer> firTypes = new ArrayList<>();
        if(listRequest.getType() == 0){
            firTypes.add(9);
            firTypes.add(36);
        }
        if(listRequest.getType() == 1){
            firTypes.add(23);
            firTypes.add(26);
            firTypes.add(27);
            firTypes.add(28);
            firTypes.add(29);
        }
        return firTypes;
    }

    public OrganModel wrapList(Organ organ){
        OrganModel organModel = new OrganModel();
        organModel.setName(organ.getName());
        organModel.setId(organ.getId());
        List<Organ> organs = organDao.getSimpleByType(organ.getId(),0);
        organModel.setOrgans(organs);
        return organModel;
    }

    public OrganModel wrapOrgan(Organ organ){
        OrganModel organModel = new OrganModel();
        BeanUtils.copyProperties(organ,organModel);
        return organModel;
    }
}
