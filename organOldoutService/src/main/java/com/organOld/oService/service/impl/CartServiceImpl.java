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
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.service.AutoValService;
import com.organOld.oService.service.CartService;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.GoodsService;
import com.organOld.oService.wrapper.CartWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Conse SaveInCart (CartRequest cartRequest){
        ProductCart productCart = cartWrapper.unwrap(cartRequest);
        cartDao.save(productCart);
        return new Conse(true);
    }

    @Override
    public String getProductIds (BTableRequest bTableRequest){
        int oldmanid = comService.getIdBySession();
        List<Integer> productIds = cartDao.getByOldmanId(oldmanid);
        return goodsService.getProductsByIds(productIds,bTableRequest);
    }

    @Override
    public String getProByOldmanId(BTableRequest bTableRequest){
        int oldmanid = comService.getIdBySession();
        List<GoodsModel> goodsModelList = cartDao.getByOldmanIdB(oldmanid).stream().map(cartWrapper::wrap).collect(Collectors.toList());
        Long size = cartDao.getSizeByOldmanId(oldmanid);
        return  comService.tableReturn(bTableRequest.getsEcho(),size,goodsModelList);
    }

    @Override
    public Conse SaveInBook(){
        int oldmanId = comService.getIdBySession();
        List<ProductCart> productCarts = cartDao.getIdsForOrder(oldmanId);
        cartDao.delByOldmanId(oldmanId);
        Collections.sort(productCarts, new Comparator<ProductCart>() {
            @Override
            public int compare(ProductCart o1, ProductCart o2) {
                if(o1.getOrganId() > o2.getOrganId())
                    return 1;
                if(o1.getOrganId() < o2.getOrganId())
                    return -1;
                return 0;
            }
        });
        List<ProductBook> productBookList = new ArrayList<>();
        int i = 0;
        for(ProductCart pc : productCarts){
            if(productBookList.size() == 0){
                ProductBook productBook = new ProductBook();
                productBook.setOldmanId(oldmanId);
                productBook.setOrganId(pc.getOrganId());
                productBook.setProductIds(pc.getProductId()+"");
                productBook.setStatus(0);
                productBookList.add(productBook);
            }
            else if(pc.getOrganId() == productBookList.get(i).getOrganId()){
                     String s1 = pc.getProductId().toString();
                     String s2 = productBookList.get(i).getProductIds();
                     productBookList.get(i).setProductIds(s1+"#"+s2);
                 } else{
                       ProductBook productBook = new ProductBook();
                       productBook.setOldmanId(oldmanId);
                       productBook.setOrganId(pc.getOrganId());
                       productBook.setProductIds(pc.getProductId()+"");
                       productBook.setStatus(0);
                       productBookList.add(productBook);
                       ++i;
                     }
        }
        productBookDao.saveAll(productBookList);
        return new Conse(true,productBookList);
    }

    @Override
    public Conse delByIds(String[] ids){
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        cartDao.delByIds(id);
        return new Conse(true);
    }
}
