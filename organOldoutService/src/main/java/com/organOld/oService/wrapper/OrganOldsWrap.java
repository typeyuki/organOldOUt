package com.organOld.oService.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.oService.contract.OrganOldsRequest;
import com.organOld.oService.enumModel.OldsStatusEnum;
import com.organOld.oService.enumModel.OrganiFirEnum;
import com.organOld.oService.model.OrganOldsModel;
import com.organOld.oService.Tool;
import com.organOld.oService.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OrganOldsWrap implements Wrap<OrganOldman,OrganOldsModel,OrganOldsRequest> {

    @Autowired
    ComService comService;

    @Override
    public OrganOldsModel wrap(OrganOldman organOldman) {
        OrganOldsModel organOldsModel =new OrganOldsModel();
        organOldsModel.setId(organOldman.getId()+"");
        if(!StringUtils.isEmpty(organOldman.getOrgan())){
            organOldsModel.setOrganId(organOldman.getOrgan().getId());
            organOldsModel.setOrganName(organOldman.getOrgan().getName());
            organOldsModel.setOrgan(organOldman.getOrgan());
        }
        if(!StringUtils.isEmpty(organOldman.getOldman())){
            organOldsModel.setOldmanId(organOldman.getOldman().getId());
            organOldsModel.setOldmanName(organOldman.getOldman().getName());
            if(organOldman.getOldman()!=null && organOldman.getOldman().getDisable()!=null) {
                if (organOldman.getOldman().getDisable() == 0) {
                    organOldsModel.setOldmanStatus("正常");
                } else if(organOldman.getOldman().getDisable() == 1){
                    organOldsModel.setOldmanStatus("被删除");
                } else{
                    organOldsModel.setOldmanStatus("未录入资料");
                }
            }
        }
//        if(!StringUtils.isEmpty(organOldman.getNoExistName())){
//            organOldsModel.setOldmanId(null);
//            organOldsModel.setOldmanName(organOldman.getNoExistName());
//            organOldsModel.setOldmanStatus("不在当前老人集中");
//        }
        organOldsModel.setNy(organOldman.getNy());
        organOldsModel.setNum(organOldman.getNum());
        organOldsModel.setTimeIn(Tool.dateToString(organOldman.getTimeIn(),"yyyy-MM-dd"));
        organOldsModel.setTimeOut(Tool.dateToString(organOldman.getTimeOut(),"yyyy-MM-dd"));
        organOldsModel.setTime(Tool.dateToString(organOldman.getTime(),"yyyy-MM-dd"));
        organOldsModel.setApplyTime(Tool.dateToString(organOldman.getApplyTime(),"yyyy-MM-dd"));
        return organOldsModel;
    }

    @Override
    public OrganOldman unwrap(OrganOldsRequest organOldsRequest) {
        OrganOldman organOldman=new OrganOldman();
        Organ organ=new Organ();
        organ.setId(organOldsRequest.getOrganId());
        organOldman.setSearch(organOldsRequest.getSearch());
        if(organOldsRequest.getOldmanId()!=null && organOldsRequest.getOldmanId()!=0){
            Oldman oldman=new Oldman();
            oldman.setId(organOldsRequest.getOldmanId());
            organOldman.setOldman(oldman);
        }
        organOldman.setNy(organOldsRequest.getNy());
        organOldman.setOrgan(organ);
        organOldman.setIsPd(organOldsRequest.getIsPd());
        organOldman.setIsExist(organOldsRequest.getIsExist());

        if(!StringUtils.isEmpty(organOldsRequest.getFirType())){
            //养老状态
            if(organOldsRequest.getFirType().equals("organ")){
                organOldman.setFirType(OrganiFirEnum.JGYL.getIndex());
                organOldman.setOldStatus(OldsStatusEnum.JG.getIndex());
            }else{
                organOldman.setFirType(OrganiFirEnum.SQYL.getIndex());
                organOldman.setOldStatus(OldsStatusEnum.SQ.getIndex());
            }
            organOldman.setNy(comService.getPrevNy());
        }
        return organOldman;
    }


}
