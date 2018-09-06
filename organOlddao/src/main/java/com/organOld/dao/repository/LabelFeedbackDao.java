package com.organOld.dao.repository;

import com.organOld.dao.entity.label.LabelFeedback;
import org.apache.ibatis.annotations.Param;

public interface LabelFeedbackDao extends BaseDao<LabelFeedback,Number> {

    LabelFeedback getByLabelIdOrganId(@Param("labelId") int labelId,@Param("organId") Integer organId);

    void deleteByLabelId(int labelId);


    void delByLabelIds(Integer[] id);
}
