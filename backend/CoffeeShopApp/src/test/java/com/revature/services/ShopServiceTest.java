package com.revature.services;

import com.revature.models.*;
import com.revature.repositories.ShopRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)

public class ShopServiceTest {

    Byte[] temp = new Byte [255];
    Picture p1 = new Picture(1,"shop",temp);
    Shop s1 = new Shop(1, "shop", p1);

    @Autowired
    ShopService ss;

    @MockBean
    ShopRepo sr;

    @Test
    void addShop(){

        Shop s = s1;
        Mockito.when(sr.save(s1)).thenReturn(new Shop(1,s1.getShopLocation(),s1.getShopPic()));
        s = ss.addShop(s);;
        Assertions.assertEquals(1,s.getShopID());
    }

    @Test
    void deleteShop() {
        Shop s = s1;
        Mockito.doNothing().when(sr).deleteById(s.getShopID());
        boolean result = ss.deleteShop(s.getShopID());
        Assertions.assertTrue(result);
    }
    @Test
    void getShop() {
        Shop s = s1;
        Optional<Shop> shopOptional = Optional.of(s);
        Mockito.when(sr.findById(s.getShopID())).thenReturn(shopOptional);
        Shop result = ss.getShop(s.getShopID());
        Assertions.assertEquals(result.getShopID(), s.getShopID());
    }
    @Test
    void updateShop(){
        Shop s = new Shop(1,"Arizona",p1);
        Mockito.when(sr.save(s)).thenReturn(new Shop(1, s.getShopLocation(), s.getShopPic()));
        s = ss.updateShop(s);
        Assertions.assertEquals(s.getShopID(),1);
    }
}
