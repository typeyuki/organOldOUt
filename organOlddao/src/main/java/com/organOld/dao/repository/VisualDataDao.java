package com.organOld.dao.repository;



import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface VisualDataDao{
    List<Map<String,Long>> getVisualData(Date date1, Date date2, Date date3, Date date4);
}
