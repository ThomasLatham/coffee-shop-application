package com.revature.services;

import com.revature.models.*;
import com.revature.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class IngredientOrderItemServiceTests {

    @Autowired
    IngredientOrderItemService iois;

    @MockBean
    IngredientOrderItemRepo ioir;


    Byte[] temp = null;
    UserRole ur1 = new UserRole(1,"customer");
    User u1 = new User(1,"first","last","123456789","email","user","password",ur1);
    UserAddress ua1 = new UserAddress(1,2125,"street","city",u1);
    Picture p1 = new Picture(1,"shop",temp);
    Shop s1 = new Shop(1, "shop", p1);
    ItemCategory ic1 = new ItemCategory(1,"food");
    MenuItem mi1 = new MenuItem(1,"a",5,10,ic1,p1);
    DailySpecial ds1 = new DailySpecial(1,s1,1,mi1);
    Ingredient i1 = new Ingredient(1, "Ingredient", 2.50);
    OrderStatus os1 = new OrderStatus(1,"Ready");
    PaymentType pt1 = new PaymentType(1, "cash");
    Order o1 = new Order(1,11232455,os1,u1,pt1,true);
    OrderItem oi1 = new OrderItem(0,o1, mi1, 2);
    IngredientOrderItem ioi1 = new IngredientOrderItem(1,oi1, i1, 1);
    IngredientOrderItem ioi2 = new IngredientOrderItem(1,oi1, i1, 3);


    @Test
    void addIngredientOrderItem() {
//        IngredientOrderItem ioi1 = new IngredientOrderItem(1,oi1, i1, 1);
        System.out.println(ioi1);

        Mockito.when(ioir.save(ioi1)).thenReturn(new IngredientOrderItem(1, ioi1.getOrderItem(), ioi1.getIngredient(), ioi1.getIngredientCount()));

        ioi1 = iois.addIngredientOrderItem(ioi1);

        Assertions.assertEquals(1, ioi1.getIngredientOrderItemId());
        Assertions.assertEquals(oi1, ioi1.getOrderItem());
        Assertions.assertEquals(i1, ioi1.getIngredient());
        Assertions.assertEquals(1, ioi1.getIngredientCount());
    }

    @Test
    void getIngredientOrderItem() {

        Optional<IngredientOrderItem> ingredientOrderItemOptional = Optional.of(ioi1);
        Mockito.when(ioir.findById(ioi1.getIngredientOrderItemId())).thenReturn(ingredientOrderItemOptional);
        IngredientOrderItem actual = iois.getIngredientOrderItem(ioi1.getIngredientOrderItemId());
        Assertions.assertEquals(actual.getIngredientOrderItemId(), ioi1.getIngredientOrderItemId());


    }

    @Test
    void getAllIngredientOrderItems() {
        List<IngredientOrderItem> ingredientOrderItemsList = (List<IngredientOrderItem>) ioir.findAll();
        Assertions.assertTrue(ingredientOrderItemsList.isEmpty());
    }

    @Test
    void updateIngredientOrderItem() {

        Optional<IngredientOrderItem> ingredientOrderItemOptional = Optional.of(ioi2);
        Mockito.when(ioir.findById(ioi2.getIngredientOrderItemId())).thenReturn(ingredientOrderItemOptional);
        IngredientOrderItem actual = iois.getIngredientOrderItem(ioi2.getIngredientOrderItemId());
        Assertions.assertEquals(actual.getIngredientOrderItemId(), ioi2.getIngredientOrderItemId());

    }

    @Test
    void submitOrder() {

    }

}
