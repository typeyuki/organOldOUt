package com.organOld.oService.wrapper;

import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.out.GoodsTypeDao;
import com.organOld.oService.contract.ProductBookRequest;
import com.organOld.oService.model.ProductTypeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSecTypeWrap implements Wrap<ProductType,ProductTypeModel,ProductBookRequest> {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Override
    public ProductTypeModel wrap(ProductType productType){
        return null;
    }

    @Override
    public ProductType unwrap(ProductBookRequest productBookRequest){
        return null;
    }
    public ProductTypeModel wrapper(ProductType productType){
        ProductTypeModel productTypeModel = new ProductTypeModel();
        BeanUtils.copyProperties(productType,productTypeModel);
        return productTypeModel;
    }
}
