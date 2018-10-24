package com.organOld.dao.repository.out;

import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.BaseDao;

import java.util.List;

public interface GoodsTypeDao extends BaseDao<ProductType,Number> {
    List<ProductType> getProductType();

    List<ProductType> getFirType(int id);

    List<ProductType> getSecType(int id);
}
