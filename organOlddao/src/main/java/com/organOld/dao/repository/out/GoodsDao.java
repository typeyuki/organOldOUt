package com.organOld.dao.repository.out;



import com.organOld.dao.entity.product.Product;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao  extends BaseDao<Product,Number> {
     List<Product> getGoodsByOrganId (Page<Product> page);

     List<Integer> getOrganIdByName (@Param("type")int type);

     Long getSizeByPageOrg (Page<Product> page);

     List<Product> getAllProducts();

     Long getAllSize();

     List<Product> getByIds (List<Integer> productIds);

     Long getSizeByIds(List<Integer> productIds);

     @Override
     Product getById(Number number);
}
