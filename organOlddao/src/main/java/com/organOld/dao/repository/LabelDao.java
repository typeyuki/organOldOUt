package com.organOld.dao.repository;


import com.organOld.dao.entity.label.*;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelDao extends BaseDao<Label,Integer> {
    List<LabelMan> getBindManByPage(Page<LabelMan> page);

    Long getBindManSizeByPage(Page<LabelMan> page);

    List<Oldman>getNoSelectManDataByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    Long getNoSelectManDataSizeByPage(@Param("page") Page<Oldman> page, @Param("labelId") int labelId);

    LabelRule getLabelRuleByLid(int labelId);

    List<LabelRule> getLabelRules();

    List<Oldman> getRuleManByPage(@Param("page") Page<Oldman> page, @Param("rule") LabelRuleToDBSelectMan labelRuleToDB);

    Long getRuleManSizeByPage(@Param("page") Page<Oldman> page, @Param("rule") LabelRuleToDBSelectMan labelRuleToDB);

    void saveLabelRule(LabelRule labelRule);

    //对应的人员绑定标签
    List<LabelMan> getManLabelByOldmanId(int oldmanId);

    List<LabelMan> getRuleManIds(@Param("rule") LabelRuleToDBSelectMan labelRuleToDB);

    String getLabelNameByLabelRuleId(int id);

    void addLabelRule(int id);

    void deleteLableManByLabelId(int labelId);


    void saveLabelMan(@Param("labelId") int labelId,@Param("oldmanIds") int[] oldmanIds);

    List<LabelSec> getAllLabelSec();
}
