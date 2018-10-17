package com.organOld.oService.wrapper;

import com.organOld.dao.entity.product.ProductBook;
import com.organOld.oService.Tool;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.ProductBookRequest;
import com.organOld.oService.model.ProductBookModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductBookWrap implements Wrap<ProductBook,ProductBookModel,ProductBookRequest>{
    @Override
    public ProductBookModel wrap(ProductBook productBook) {
        ProductBookModel productBookModel=new ProductBookModel();
        productBookModel.setId(productBook.getId());
        productBookModel.setTime(Tool.dateToString(productBook.getTime(), TimeConst.DATA_FORMAT_YMD));
        productBookModel.setIds(productBook.getProductIds());
        productBookModel.setOldman(productBook.getOldman());
        productBookModel.setStatus(productBook.getStatus());
        return productBookModel;
    }

    @Override
    public ProductBook unwrap(ProductBookRequest productBookRequest) {
        ProductBook productBook=new ProductBook();
        BeanUtils.copyProperties(productBookRequest,productBook);
        return productBook;
    }
}
