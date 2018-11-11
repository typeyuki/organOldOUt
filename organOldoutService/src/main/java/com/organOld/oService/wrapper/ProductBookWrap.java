package com.organOld.oService.wrapper;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.ProductDao;
import com.organOld.dao.repository.out.GoodsDao;
import com.organOld.oService.Tool;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.ProductBookRequest;
import com.organOld.oService.model.ProductBookModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBookWrap implements Wrap<ProductBook,ProductBookModel,ProductBookRequest>{
    @Autowired
    GoodsDao productDao;
    @Autowired
    OrganDao organDao;
    @Override
    public ProductBookModel wrap(ProductBook productBook) {
        ProductBookModel productBookModel=new ProductBookModel();
        productBookModel.setId(productBook.getId());
        productBookModel.setTime(Tool.dateToString(productBook.getTime(), TimeConst.DATA_FORMAT_YMD));
        if(productBook.getStatus() == 0)
            productBookModel.setStatus("未处理");
        else
            productBookModel.setStatus("已处理");
        Product p = productDao.getById(Integer.parseInt(productBook.getProductIds()));
        productBookModel.setName(p.getProductType().getName());
        Organ organ = organDao.getSimpleById(productBook.getOrganId());
        productBookModel.setOrganName(organ.getName());
       // productBookModel.setOldman(productBook.getOldman());

        return productBookModel;
    }

    @Override
    public ProductBook unwrap(ProductBookRequest productBookRequest) {
        ProductBook productBook=new ProductBook();
        BeanUtils.copyProperties(productBookRequest,productBook);
        return productBook;
    }
}
