package com.organOld.oService.service.impl;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.entity.product.ProductCart;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.ProductBookDao;
import com.organOld.dao.repository.out.CartDao;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.service.*;
import com.organOld.oService.wrapper.CartWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    ProductBookDao productBookDao;
    @Autowired
    CartWrap cartWrapper;
    @Autowired
    GoodsService goodsService;
    @Autowired
    ComService comService;
    @Autowired
    MessageService messageService;

    @Override
    @Transactional
    public Conse SaveInCart (CartRequest cartRequest){
        ProductCart productCart = cartWrapper.unwrap(cartRequest);
        if(productCart.getOldmanId()==null || productCart.getOldmanId() == 0)
            comService.checkIsUser(productCart);
        if(productCart.getOldmanId()==null || productCart.getOldmanId() == 0)
            throw new ServiceException("请先登录");
        cartDao.save(productCart);
        return new Conse(true);
    }

    /**
     * 暂时不用，用下面那一个
     * @param bTableRequest
     * @return
     */
    @Override
    public String getProductIds (BTableRequest bTableRequest){
        int oldmanid = comService.getIdBySession();
        List<Integer> productIds = cartDao.getByOldmanId(oldmanid);
        return goodsService.getProductsByIds(productIds,bTableRequest);
    }

    @Override
    public String getProByOldmanId(BTableRequest bTableRequest,Integer oldmanId){
        Integer userId = comService.getOldsIdBySession();
        if(userId == null || userId == 0)
            userId = oldmanId;
        if (userId == 0)
            throw new OtherServiceException("请登录");
        List<GoodsModel> goodsModelList = cartDao.getByOldmanIdB(userId).stream().map(cartWrapper::wrap).collect(Collectors.toList());
        Long size = cartDao.getSizeByOldmanId(userId);
        return  comService.tableReturn(bTableRequest.getsEcho(),size,goodsModelList);
    }

    @Override
    @Transactional
    public Conse SaveInBook(Integer oldmanId){
        Integer userId = oldmanId;
        if (userId == 0)
            throw new ServiceException("请登录");
        List<ProductCart> productCarts = new ArrayList<>();
        try {
            productCarts  = cartDao.getIdsForOrder(userId);
            cartDao.delByOldmanId(userId);
        }catch(Exception e){
            throw new ServiceException("购物车为空");
        }
        List<ProductBook> productBookList = new ArrayList<>();

        for(ProductCart pc : productCarts){
            ProductBook productBook = new ProductBook();
            productBook.setProductIds(pc.getProductId()+"");
            productBook.setStatus(0);
            productBook.setOldmanId(userId);
            productBook.setOrganId(pc.getOrganId());
            productBookList.add(productBook);
            MessageRequest messageRequest = new MessageRequest();
            messageRequest.setOldmanId(oldmanId);
            messageRequest.setContent("有一条新的订单");
            messageRequest.setOrganId(pc.getOrganId());
            messageRequest.setType(23);
            messageService.saveCartMessage(messageRequest);
        }
//        Collections.sort(productCarts, new Comparator<ProductCart>() {
//            @Override
//            public int compare(ProductCart o1, ProductCart o2) {
//                if(o1.getOrganId() > o2.getOrganId())
//                    return 1;
//                if(o1.getOrganId() < o2.getOrganId())
//                    return -1;
//                return 0;
//            }
//        });
//        List<ProductBook> productBookList = new ArrayList<>();
//        int i = 0;
//        for(ProductCart pc : productCarts){
//            if(productBookList.size() == 0){
//                ProductBook productBook = new ProductBook();
//                productBook.setOldmanId(userId);
//                productBook.setOrganId(pc.getOrganId());
//                productBook.setProductIds(pc.getProductId()+"");
//                productBook.setStatus(0);
//                productBookList.add(productBook);
//            }
//            else if(pc.getOrganId() == productBookList.get(i).getOrganId()){
//                     String s1 = pc.getProductId().toString();
//                     String s2 = productBookList.get(i).getProductIds();
//                     productBookList.get(i).setProductIds(s1+"#"+s2);
//                 } else{
//                       ProductBook productBook = new ProductBook();
//                       productBook.setOldmanId(userId);
//                       productBook.setOrganId(pc.getOrganId());
//                       productBook.setProductIds(pc.getProductId()+"");
//                       productBook.setStatus(0);
//                       productBookList.add(productBook);
//                       ++i;
//                     }
//        }
        productBookDao.saveAll(productBookList);
        return new Conse(true,productBookList);
    }

    @Override
    @Transactional
    public Conse delByIds(String[] ids){
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        cartDao.delByIds(id);
        return new Conse(true);
    }
}
