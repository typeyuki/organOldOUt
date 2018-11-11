package com.organOld.oService.wrapper;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganReg;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.OrganModel;
import com.organOld.oService.tool.ImgUpload;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.organOld.oService.contract.OrganRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class OrganWrap implements Wrap<Organ,OrganModel,OrganRequest> {
    @Override
    public OrganModel wrap(Organ organ){
        return null;
    }
    @Override
    public Organ unwrap(OrganRequest organRequest){
        Organ organ=new Organ();
        BeanUtils.copyProperties(organRequest,organ);
        organ.setOrganFirTypeId(organRequest.getType());
        return organ;
    }
    public Organ unwrapRegOrgan(OrganRegRequest organRegRequest, HttpServletRequest request) {
        Organ organ=new Organ();
//        if(organRegRequest.getOrganFirType()==3)
//            organ.setStatus("2");
        BeanUtils.copyProperties(organRegRequest,organ);
        if(organRegRequest.getAuth()!=null && organRegRequest.getAuth().length>0){
            List<String> auths= Arrays.asList(organRegRequest.getAuth());
            if(auths.contains("sign"))organ.setAuthSign(1);else organ.setAuthSign(0);
            if(auths.contains("product"))organ.setAuthProduct(1);else organ.setAuthProduct(0);
            if(auths.contains("consume"))organ.setAuthConsume(1);else organ.setAuthConsume(0);
            if(auths.contains("info"))organ.setAuthQueryInfo(1);else organ.setAuthQueryInfo(0);
            if(auths.contains("integral"))organ.setAuthQueryIntegral(1);else organ.setAuthQueryIntegral(0);
        }else{
            organ.setAuthSign(0);
            organ.setAuthProduct(0);
            organ.setAuthConsume(0);
            organ.setAuthQueryInfo(0);
            organ.setAuthQueryIntegral(0);
        }
        if(organRegRequest.getPic() != null){
            try {
                String path= ImgUpload.uploadFile(organRegRequest.getPic(), request,"organ");
                int index = path.indexOf("img");
                String picUrl= path.substring(index, path.length());
                organ.setImgUrl(picUrl);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return organ;
    }
    public OrganReg unwrapRegOrganReg(OrganRegRequest organRegRequest) {
        OrganReg organReg=new OrganReg();
        BeanUtils.copyProperties(organRegRequest,organReg);
        organReg.setPhone(organRegRequest.getPersonPhone());
        return organReg;
    }

    public AutoValModel wrapJw(Organ organ){
        AutoValModel autoValModel = new AutoValModel();
        autoValModel.setId(organ.getId());
        autoValModel.setValue(organ.getName());
        return autoValModel;
    }
}
