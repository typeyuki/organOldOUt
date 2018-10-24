package com.organOld.oService.service.impl;

import com.organOld.dao.repository.ProductTypeDao;
import com.organOld.dao.repository.out.GoodsTypeDao;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.ProductTypeModel;
import com.organOld.oService.service.ProductTypeService;
import com.organOld.oService.wrapper.ProductTypeWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Autowired
    ProductTypeWrap productTypeWrap;
    @Override
    public Conse getProductType(){
        List<ProductTypeModel> productTypeModels = goodsTypeDao.getProductType().stream().map(productTypeWrap::wrap).collect(Collectors.toList());
        if(productTypeModels == null)
            throw new ServiceException("数据库中可能没有数据");
        return new Conse(true,productTypeModels);
    }

}
