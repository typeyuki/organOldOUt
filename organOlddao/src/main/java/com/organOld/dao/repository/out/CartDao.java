package com.organOld.dao.repository.out;

import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.entity.product.ProductCart;
import com.organOld.dao.repository.BaseDao;

import java.util.List;

public interface CartDao extends BaseDao<ProductCart,Number> {

    List<Integer> getByOldmanId(int oldmanId);

    List<ProductCart> getByOldmanIdB(int oldmanId);

    List<ProductCart> getIdsForOrder(int oldmanId);

    List<ProductCart> getByOrganId(int oldmanId, int organId);

    Long getSizeByOldmanId(int oldmanId);

    void delByIds(String[] ids);

    void delByOldmanId(int oldmanId);

}
