package com.organOld.oService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.product.Product;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GoodsWrap implements Wrap<Product,GoodsModel,GoodsRequest> {

    @Override
    public GoodsModel wrap(Product product) {
        GoodsModel goodsModel =new GoodsModel();
        goodsModel.setSecType(product.getProductType().getName());
        goodsModel.setFirType(product.getProductType().getFirProductType().getName());
        BeanUtils.copyProperties(product, goodsModel);
        goodsModel.setTime(Tool.dateToString(product.getTime(), TimeConst.DATA_FORMAT_YMD));
        return goodsModel;
    }

    @Override
    public Product unwrap(GoodsRequest goodsRequest) {
        Product product=new Product();
        if(goodsRequest.getPrice()!=null && !goodsRequest.getPrice().equals(""))
            product.setPrice(Double.parseDouble(goodsRequest.getPrice()));
        product.setIntro(goodsRequest.getIntro());
        if(goodsRequest.getId()!=null)
        product.setId(goodsRequest.getId());
        product.setName(goodsRequest.getName());
        product.setOrganId(goodsRequest.getOrganId());
        product.setType(goodsRequest.getType());
        return product;
    }

}
