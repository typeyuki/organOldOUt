package com.organOld.oService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.product.Product;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.ProductTypeDao;
import com.organOld.oService.constant.Constant;
import com.organOld.oService.constant.TimeConst;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.Tool;
import com.organOld.oService.service.ProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsWrap implements Wrap<Product,GoodsModel,GoodsRequest> {
    @Autowired
    OrganDao organDao;
    @Autowired
    ProductTypeDao productTypeDao;

    @Override
    public GoodsModel wrap(Product p ){
        GoodsModel goodsModel = new GoodsModel();
        if(p != null){
            goodsModel.setName(p.getProductType().getName());
            if(p.getImgUrl() != null)
                p.setImgUrl(Constant.url+p.getImgUrl());
            BeanUtils.copyProperties(p,goodsModel);
            goodsModel.setType(p.getProductType().getId()+"");
            if(productTypeDao.getParentById(p.getProductType().getId()) == 23)
                goodsModel.setButton("book");
            else
                goodsModel.setButton("saveInCart");
            goodsModel.setTime(Tool.dateToString(p.getTime(),TimeConst.DATA_FORMAT_YMD));
        }
        if(p.getOrganId() != null) {
            Organ organ = organDao.getSimpleById(p.getOrganId());
            goodsModel.setPhone(organ.getPhone());
            goodsModel.setOrganName(organ.getName());
            goodsModel.setWebUrl(organ.getWebUrl());
        }
        return goodsModel;
    }
    public GoodsModel wrapBook(Product p){
        GoodsModel goodsModel = new GoodsModel();
        if(p != null){
            goodsModel.setName(p.getProductType().getName());
            goodsModel.setOrganId(p.getOrganId());
        }
        if(p.getOrganId() != null){
            Organ organ = organDao.getSimpleById(p.getOrganId());
            goodsModel.setOrganName(organ.getName());
        }
        return goodsModel;
    }

//    public GoodsModel wrap(Product product) {
//        GoodsModel goodsModel =new GoodsModel();
//        if(product != null) {
//            goodsModel.setSecType(product.getProductType().getName());
//            goodsModel.setFirType(product.getProductType().getFirProductType().getName());
//            BeanUtils.copyProperties(product, goodsModel);
//            if (product.getProductType().getType().equals("1"))
//                goodsModel.setName(goodsModel.getSecType());
//            if (product.getProductType().getFirProductType().getType().equals("1"))
//                goodsModel.setName(goodsModel.getFirType());
//            goodsModel.setTime(Tool.dateToString(product.getTime(), TimeConst.DATA_FORMAT_YMD));
//        }
//        return goodsModel;
//    }

    @Override
    public Product unwrap(GoodsRequest goodsRequest) {
        Product product=new Product();
        if(goodsRequest.getPrice()!=null && !goodsRequest.getPrice().equals(""))
            product.setPrice(Double.parseDouble(goodsRequest.getPrice()));
        product.setIntro(goodsRequest.getIntro());
        if(goodsRequest.getId()!=null)
        product.setId(goodsRequest.getId());
        product.setOrganId(goodsRequest.getOrganId());
        product.setType(goodsRequest.getType());
        return product;
    }


}
