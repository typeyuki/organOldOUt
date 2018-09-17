package com.organOld.oService.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductCart;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.model.GoodsModel;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CartWrap implements Wrap<ProductCart,GoodsModel,CartRequest> {
    @Override
    public GoodsModel wrap (ProductCart productCart){

        return null;
    }
    @Override
    public ProductCart unwrap(CartRequest cartRequest){
        ProductCart productCart = new ProductCart();
        BeanUtils.copyProperties(cartRequest,productCart);
        return productCart;
    }
}
