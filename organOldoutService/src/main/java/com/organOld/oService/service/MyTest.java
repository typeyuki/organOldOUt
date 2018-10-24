package com.organOld.oService.service;



import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Card;
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

import java.util.ArrayList;
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
    OutVisualService outVisualService;

    @Autowired
    CartService cartService;
    @Autowired
    OldsUserService oldsUserService;
    @Autowired
    ProductTypeService productTypeService;

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
    public void testPersonalInfo(){
        PersonalInfoModel personalInfoModel = fileService.getPersonalInfo(36);
        personalInfoModel.getHome();
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
        String result = goodsService.getByProductPage(goodsRequest,1);
        String text = result;

    }

    @Test
    public void testProductA(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        String result = goodsService.getAllProduct();
        String text = result;
    }

    @Test
    public void testProductB(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        goodsRequest.setOrganId(7);
        String result = goodsService.getProductByOrganId(goodsRequest,1);
        String text = result;
    }

    @Test
    public void testPruductC(){
        Conse conse = goodsService.getOrganByProduct(16);
        conse.getData();
    }

    @Test
    public void testProductD(){
        Conse conse = goodsService.getTypeByParent(22);
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

//    @Test
//    public void testCartB(){
//        BTableRequest bTableRequest = new BTableRequest();
//        bTableRequest.setiDisplayLength(10);
//        bTableRequest.setiDisplayStart(0);
//        String result = cartService.getProByOldmanId(bTableRequest);
//        String text = result;
//    }

//    @Test
//    public void testCartC(){
//        Conse conse = cartService.SaveInBook();
//        conse.getData();
//    }
    @Test
    public void testOutVisual(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldmanRequest oldmanRequest = new OldmanRequest();
        String[] jwIds = {"1","58","59","2"};
        oldmanRequest.setJw(jwIds);
        Conse conse = outVisualService.getNeiborComAndNum(oldmanRequest,bTableRequest);
        conse.getData();
    }

    @Test
    public void testProductBook(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        ProductBookRequest productBookRequest = new ProductBookRequest();
        productBookRequest.setOldmanId(36);
        String text = goodsService.getBookByPage(productBookRequest,bTableRequest);
        String result = text;
    }
    @Test
    public void testUser(){
        String name = "202018";
        Card user = oldsUserService.getByUsername(name);
        user.getMoney();
    }

    @Test
    public void testProductType(){
        Conse conse = productTypeService.getProductType();
        conse.getData();
    }
}
