package com.organOld.oService.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.out.GoodsTypeDao;
import com.organOld.oService.contract.ProductBookRequest;
import com.organOld.oService.model.ProductTypeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductTypeWrap implements Wrap<ProductType,ProductTypeModel,ProductBookRequest> {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Autowired
    ProductFirTypeWrap productFirTypeWrap;
    @Override
    public ProductTypeModel wrap(ProductType productType){
        ProductTypeModel productTypeModel = new ProductTypeModel();
        BeanUtils.copyProperties(productType,productTypeModel);
        List<ProductTypeModel> productTypeModels = goodsTypeDao.getFirType(productType.getId()).stream().map(productFirTypeWrap::wraper).collect(Collectors.toList());
        productTypeModel.setProductTypeModels(productTypeModels);
        return productTypeModel;

    }

    @Override
    public ProductType unwrap(ProductBookRequest productBookRequest){
        return null;
    }


}
