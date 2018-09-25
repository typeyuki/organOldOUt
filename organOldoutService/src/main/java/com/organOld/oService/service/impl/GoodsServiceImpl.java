package com.organOld.oService.service.impl;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.ProductDao;
import com.organOld.dao.repository.ProductTypeDao;
import com.organOld.dao.repository.out.AutoValDao;
import com.organOld.dao.repository.out.GoodsDao;
import com.organOld.dao.util.Page;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.GoodsRequest;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.model.AutoValModel;
import com.organOld.oService.model.GoodsModel;
import com.organOld.oService.service.ComService;
import com.organOld.oService.service.GoodsService;
import com.organOld.oService.wrapper.AutoValWrap;
import com.organOld.oService.wrapper.GoodsWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    ComService comService;
    @Autowired
    GoodsWrap goodsWrapper;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    AutoValDao autoValDao;
    @Autowired
    AutoValWrap autoValWrapper;
    @Autowired
    ProductTypeDao productTypeDao;
    @Override
    public String getByProductPage (GoodsRequest goodsRequest, BTableRequest bTableRequest){
        Page<Product> page= comService.getPage(bTableRequest,"product");
        Product product=  goodsWrapper.unwrap(goodsRequest);
//        if(product.getOrganId()==null || product.getOrganId()==0){
//            //机构账号页面
//            comService.checkIsOrgan(product);
//        }
        page.setEntity(product);
        List<GoodsModel> goodsModelList =goodsDao.getByPage(page).stream().map(goodsWrapper::wrap).collect(Collectors.toList());
        Long size=goodsDao.getSizeByPage(page);
        if(goodsModelList.size() == 0|| size == 0)
            throw new OtherServiceException("无法获取商品信息");
        return comService.tableReturn(bTableRequest.getsEcho(),size, goodsModelList);
    }

    @Override
    public String getProductByOrganId(GoodsRequest goodsRequest, BTableRequest bTableRequest){
        Page<Product> page= comService.getPage(bTableRequest,"product");
        Product product=  goodsWrapper.unwrap(goodsRequest);
//        if(product.getOrganId()==null || product.getOrganId()==0){
//            //机构账号页面
//            comService.checkIsOrgan(product);
//        }
        page.setEntity(product);
        List<GoodsModel> goodsModelList =goodsDao.getGoodsByOrganId(page).stream().map(goodsWrapper::wrap).collect(Collectors.toList());
        Long size=goodsDao.getSizeByPageOrg(page);
        if(size == 0)
            throw new OtherServiceException("获取商品信息出错.");
        return comService.tableReturn(bTableRequest.getsEcho(),size, goodsModelList);
    }
    @Override
    public Conse getOrganByProduct(int type){
        List<Integer> organIds = goodsDao.getOrganIdByName(type);
        List<AutoValModel> organNames = autoValDao.getByIds(organIds).stream().map(autoValWrapper::wrap).collect(Collectors.toList());
        if(organNames.size() == 0)
            throw new ServiceException("获取机构信息出错.");
        return new Conse(true,organNames);
    }

    @Override
    public String getAllProduct(BTableRequest bTableRequest){
        List<GoodsModel> goodsModelList = goodsDao.getAllProducts().stream().map(goodsWrapper::wrap).collect(Collectors.toList());
        Long size = goodsDao.getAllSize();
        if(size == 0)
            throw new OtherServiceException("获取商品信息出错.");
        return comService.tableReturn(bTableRequest.getsEcho(),size,goodsModelList);
    }

    @Override
    public Conse getTypeByParent(int parent){
        List<ProductType> productTypes = productTypeDao.getByParent(parent);
        return new Conse(true,productTypes);
    }

    @Override
    public String getProductsByIds(List<Integer> productIds,BTableRequest bTableRequest){
        List<GoodsModel> goodsModelList = goodsDao.getByIds(productIds).stream().map(goodsWrapper::wrap).collect(Collectors.toList());
        Long size = goodsDao.getSizeByIds(productIds);
        if(size == 0)
            throw new OtherServiceException("获取购物车信息失败.");
        return comService.tableReturn(bTableRequest.getsEcho(),size,goodsModelList);
    }
    @Override
    public GoodsModel getProductById(int productId){
        Product product = goodsDao.getById(productId);
        GoodsModel goodsModel = goodsWrapper.wrap(product);
        return goodsModel;
    }
}
