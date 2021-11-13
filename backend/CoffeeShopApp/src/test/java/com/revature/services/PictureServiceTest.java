package com.revature.services;

import com.revature.models.*;
import com.revature.repositories.OrderRepo;
import com.revature.repositories.PictureRepo;
import com.revature.repositories.PictureRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
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
    void deletePicture() {
        Picture p = p1;
        Mockito.doNothing().when(pr).deleteById(p.getPicID());
        boolean result = ps.deletePicture(p.getPicID());
        Assertions.assertTrue(result);
    }

    @Test
    void deletePictureIllegalArgument() {

        Picture p = p1;

        Mockito.doThrow(IllegalArgumentException.class).when(pr).deleteById(p1.getPicID());

        boolean result = ps.deletePicture(p.getPicID());

        Assertions.assertFalse(result);
    }
    
    @Test
    void getAllPictures() {

        List<Picture> shops = new ArrayList<>();
        shops.add(p1);

        Mockito.when(pr.findAll()).thenReturn(shops);

        List<Picture> actual = ps.getAllPictures();

        List<Picture> expected = shops;

        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void getPicture() {
        Picture p = p1;
        Optional<Picture> pictureOptional = Optional.of(p);
        Mockito.when(pr.findById(p.getPicID())).thenReturn(pictureOptional);
        Picture result = ps.getPicture(p.getPicID());
        Assertions.assertEquals(result.getPicID(), p.getPicID());
    }
    @Test
    void updatePicture(){
        Picture p = new Picture(1,"Arizona",temp);
        Mockito.when(pr.save(p)).thenReturn(new Picture(1, p.getPicName(), p.getPicType()));
        p = ps.updatePicture(p);
        Assertions.assertEquals(p.getPicID(),1);
    }
}
