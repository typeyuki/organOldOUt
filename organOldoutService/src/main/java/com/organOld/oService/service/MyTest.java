package com.organOld.oService.service;



import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.oService.contract.*;
import com.organOld.oService.model.LinkmanModel;
import com.organOld.oService.model.OldsHealthModel;
import com.organOld.oService.model.PersonalInfoModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class MyTest {
    @Autowired
    AutoValService autoValService;
    @Autowired
    FileService fileService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CartService cartService;

    @Test
    public void myTest() {
        OldsHealthModel oldmanHealth = fileService.getOldmanHealth(36);
        oldmanHealth.getAbiliInfo();
    }

    @Test
    public void testLabel() {
        Conse conse = fileService.getByLabel(36);
        conse.getData();
    }

    @Test
    public void testReocrd(){
        BTableRequest bTableRequest = new BTableRequest();
        CardLogsRequest cardLogsRequest = new CardLogsRequest();
        cardLogsRequest.setOldmanId(3374);
        cardLogsRequest.setType(9);
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        String result = fileService.getByCardPage(bTableRequest,cardLogsRequest);
        String tesxt= result;
    }
    @Test
    public void testProduct(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        goodsRequest.setType(7);
        String result = goodsService.getByProductPage(goodsRequest,bTableRequest);
        String text = result;

    }

    @Test
    public void testProductA(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        String result = goodsService.getAllProduct(bTableRequest);
        String text = result;
    }

    @Test
    public void testProductB(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        goodsRequest.setOrganId(7);
        String result = goodsService.getProductByOrganId(goodsRequest,bTableRequest);
        String text = result;
    }

    @Test
    public void testPruductC(){
        Conse conse = goodsService.getOrganByProduct(16);
        conse.getData();
    }

    @Test
    public void testProductD(){
        Conse conse = goodsService.getTypeByParent(3);
        conse.getData();
    }

    @Test
    public void testCartA(){
        CartRequest cartRequest = new CartRequest();
        cartRequest.setOldmanId(36);
        cartRequest.setOrganId(9);
        cartRequest.setProductId(3);
        Conse conse = cartService.SaveInCart(cartRequest);
        conse.getClass();
    }
}
