package com.organOld.dao.repository;

import com.organOld.dao.entity.Card;
import com.organOld.dao.util.bean.QrCodeData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardDao extends BaseDao<Card,Number>{
    void delByOldmanIds(@Param("existOldmanIds") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);

    void addMoney(@Param("ids") String[] ids,@Param("money") Double money);

    Card getByOldmanId(int oldmanId);

    Card getByCid(String cid);

    List<QrCodeData> getQrDataByIds(String[] ids);

    void ableByOldmanIds(@Param("existOldmanIds") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);
}
