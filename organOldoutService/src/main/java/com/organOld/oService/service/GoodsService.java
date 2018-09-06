package com.organOld.oService.service;

import com.organOld.dao.entity.product.ProductType;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.GoodsRequest;

import java.util.List;

public interface GoodsService {
    String getByProductPage (GoodsRequest goodsRequest, BTableRequest bTableRequest);

    String getProductByOrganId (GoodsRequest goodsRequest, BTableRequest bTableRequest);

    Conse getOrganByProduct (String name);

    String getAllProduct(BTableRequest bTableRequest);

    List<ProductType> getTypeByParent (int parent);
}
