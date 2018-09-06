package com.organOld.oService.wrapper;

import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.oService.contract.ContactsRequest;
import com.organOld.oService.model.LinkmanModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class ContactsWrap implements Wrap<Linkman,LinkmanModel,ContactsRequest> {
    @Override
    public LinkmanModel wrap(Linkman linkman) {
        LinkmanModel linkmanModel=new LinkmanModel();
        linkmanModel.setId(linkman.getId()+"");
        //linkmanModel.setOldman(linkman.getOldman().getId()+"："+linkman.getOldman().getName());
        linkmanModel.setName(linkman.getName());
        linkmanModel.setPhone(linkman.getPhone());
        linkmanModel.setRelation(linkman.getRelation());
       // linkmanModel.setTime(Tool.dateToString(linkman.getTime(),"yyyy-MM-dd"));

        return linkmanModel;
    }

    @Override
    public Linkman unwrap(ContactsRequest contactsRequest) {
        Linkman linkman=new Linkman();
        BeanUtils.copyProperties(contactsRequest,linkman);
        return linkman;
    }
}
