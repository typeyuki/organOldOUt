package com.organOld.oService.service.impl;

import com.organOld.dao.entity.product.ProductCart;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.out.CartDao;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.service.CartService;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.GoodsService;
import com.organOld.oService.wrapper.CartWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    CartWrap cartWrapper;
    @Autowired
    GoodsService goodsService;
    @Autowired
    ComService comService;
    @Override
    public Conse SaveInCart (CartRequest cartRequest){
        ProductCart productCart = cartWrapper.unwrap(cartRequest);
        cartDao.save(productCart);
        return new Conse(true);
    }

    @Override
    public String getProductIds (int oldmanId, BTableRequest bTableRequest){
        List<Integer> productIds = cartDao.getByOldmanId(oldmanId);
        return goodsService.getProductsByIds(productIds,bTableRequest);
    }

    @Override
    public String getProByOldmanId(int oldmanId, BTableRequest bTableRequest){
        List<GoodsModel> goodsModelList = cartDao.getByOldmanIdB(oldmanId).stream().map(cartWrapper::wrap).collect(Collectors.toList());
        Long size = cartDao.getSizeByOldmanId(oldmanId);
        return  comService.tableReturn(bTableRequest.getsEcho(),size,goodsModelList);
    }

    @Override
    public void delByIds(String[] ids){
        cartDao.delByIds(ids);
    }
}
