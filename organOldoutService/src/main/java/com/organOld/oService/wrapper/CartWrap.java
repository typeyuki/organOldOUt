package com.organOld.oService.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductCart;
import com.organOld.oService.Tool;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CartWrap implements Wrap<ProductCart,GoodsModel,CartRequest> {
    @Autowired
    GoodsService goodsService;

    @Override
    public GoodsModel wrap (ProductCart productCart){
        GoodsModel goodsModel = goodsService.getProductById(productCart.getProductId());
        goodsModel.setTime(Tool.dateToString(productCart.getTime(), TimeConst.DATA_FORMAT_YMD));
        goodsModel.setId(productCart.getId());
        return goodsModel;
    }
    @Override
    public ProductCart unwrap(CartRequest cartRequest){
        ProductCart productCart = new ProductCart();
        BeanUtils.copyProperties(cartRequest,productCart);
        return productCart;
    }
}
