package com.revature.services;

import com.revature.models.*;
import com.revature.repositories.OrderRepo;
import com.revature.repositories.PictureRepo;
import com.revature.repositories.ShopRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)

public class PictureServiceTest {

    Byte[] temp = new Byte [255];
    Picture p1 = new Picture(1,"shop",temp);
    Shop s1 = new Shop(1, "shop", p1);

    @Autowired
    PictureService ps;

    @MockBean
    PictureRepo pr;

    @Test
    void addPicture(){

        Picture p = p1;
        Mockito.when(pr.save(p1)).thenReturn(new Picture(1,p1.getPicName(),p1.getPicType()));
        p = ps.addPicture(p);;
        Assertions.assertEquals(1,p.getPicID());
    }

    @Test
    void deleteShop() {
        Picture p = p1;
        Mockito.doNothing().when(pr).deleteById(p.getPicID());
        boolean result = ps.deletePicture(p.getPicID());
        Assertions.assertTrue(result);
    }
    @Test
    void getShop() {
        Picture p = p1;
        Optional<Picture> pictureOptional = Optional.of(p);
        Mockito.when(pr.findById(p.getPicID())).thenReturn(pictureOptional);
        Picture result = ps.getPicture(p.getPicID());
        Assertions.assertEquals(result.getPicID(), p.getPicID());
    }
    @Test
    void updateShop(){
        Picture p = new Picture(1,"Arizona",temp);
        Mockito.when(pr.save(p)).thenReturn(new Picture(1, p.getPicName(), p.getPicType()));
        p = ps.updatePicture(p);
        Assertions.assertEquals(p.getPicID(),1);
    }
}
