package com.organOld.oService.wrapper;

import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.oService.contract.HomeOldsRequest;
import com.organOld.oService.enumModel.HomeTypeEnum;
import com.organOld.oService.model.HomeOldsModel;
import com.organOld.oService.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HomeOldsWrap implements Wrap<HomeOldman,HomeOldsModel,HomeOldsRequest> {

    @Override
    public HomeOldsModel wrap(HomeOldman homeOldman) {
        HomeOldsModel homeOldmanModel=new HomeOldsModel();
        homeOldmanModel.setHomeName(homeOldman.getHome().getSecType());
        homeOldmanModel.setHomeType(HomeTypeEnum.getValue(homeOldman.getHome().getFirType()));
        homeOldmanModel.setId(homeOldman.getId());
        homeOldmanModel.setNy(homeOldman.getNy());
        if(!StringUtils.isEmpty(homeOldman.getOldman())){
            homeOldmanModel.setOldmanId(homeOldman.getOldman().getId());
            homeOldmanModel.setOldmanName(homeOldman.getOldman().getName());
            if(homeOldman.getOldman()!=null && homeOldman.getOldman().getDisable()!=null) {
                if (homeOldman.getOldman().getDisable() == 0) {
                    homeOldmanModel.setOldmanStatus("正常");
                } else if(homeOldman.getOldman().getDisable() == 1){
                    homeOldmanModel.setOldmanStatus("被删除");
                }
                else{
                    homeOldmanModel.setOldmanStatus("未录入资料");
                }

            }
        }

        if(homeOldman.getHome().getFirType()== HomeTypeEnum.CHX.getIndex()){
            homeOldmanModel.setIsService((homeOldman.getIsService()==null || homeOldman.getIsService()==0)?"未获得":"已获得");
        }else{
            homeOldmanModel.setTimeIn(Tool.dateToString(homeOldman.getTimeIn(),"yyyy-MM-dd"));
            homeOldmanModel.setTimeOut(Tool.dateToString(homeOldman.getTimeOut(),"yyyy-MM-dd"));
        }
        homeOldmanModel.setTime(Tool.dateToString(homeOldman.getTime(),"yyyy-MM-dd"));
        homeOldmanModel.setOrgan(homeOldman.getOrgan());
        return homeOldmanModel;
    }

    @Override
    public HomeOldman unwrap(HomeOldsRequest homeOldmanRequest) {
        HomeOldman homeOldman=new HomeOldman();
        BeanUtils.copyProperties(homeOldmanRequest,homeOldman);
        homeOldman.setOldStatus(3);
        return homeOldman;
    }


}
