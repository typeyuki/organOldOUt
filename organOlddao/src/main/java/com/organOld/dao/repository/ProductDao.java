package com.organOld.dao.repository;

import com.organOld.dao.entity.product.Product;

public interface ProductDao extends BaseDao<Product,Number>{
    Product getById(String id);
}
