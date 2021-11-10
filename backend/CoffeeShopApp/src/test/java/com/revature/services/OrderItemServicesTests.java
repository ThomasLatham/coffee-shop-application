package com.revature.services;

import com.revature.models.*;
import com.revature.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class OrderItemServicesTests {
    @Autowired
    OrderItemService os;

    @MockBean
    DailySpecialRepo dsr;

    @MockBean
    IngredientRepo ir;

    @MockBean
    IngredientOrderItemRepo ioir;

    @MockBean
    ItemCategoryRepo icr;

    @MockBean
    MenuItemIngredientRepo miir;

    @MockBean
    MenuItemRepo mir;

    @MockBean
    OrderItemRepo oir;

    @MockBean
    OrderRepo orr;

    @MockBean
    OrderStatusRepo osr;

    @MockBean
    PaymentTypeRepo ptr;

    @MockBean
    PictureRepo pr;

    @MockBean
    ShopRepo sr;

    @MockBean
    UserAddressRepo uar;

    @MockBean
    UserRepo ur;

    @MockBean
    UserRoleRepo urr;

    @Test
    void addOrderItem() {
        Byte[] temp = new Byte [255];
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

        Mockito.when(oir.save(oi1)).thenReturn(new OrderItem(1, oi1.getOrderID(), oi1.getMenuItem(), oi1.getItemCount()));

        oi1 = os.addOrderItem(oi1);

        Assertions.assertEquals(1, oi1.getOrderItemID());
        Assertions.assertEquals(oi1, oi1);
        Assertions.assertEquals(mi1, mi1);
        Assertions.assertEquals(2, oi1.getItemCount());
    }





    @Test
    void getOrderItem() {

    Byte[] temp = new Byte [255];
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

    Optional<OrderItem> orderItemOptional = Optional.of(oi1);
    Mockito.when(oir.findById(oi1.getOrderItemID())).thenReturn(orderItemOptional);
    OrderItem actual = os.getOrderItem(oi1.getOrderItemID());
    Assertions.assertEquals(actual.getOrderItemID(), oi1.getOrderItemID());


    }

// references is needed
//    @Test
//    void getOrderItem(id) {
//
//
//    }
////
//
//
    @Test
    void updateOrderItem() {
    Byte[] temp = new Byte [255];
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
    OrderItem oi2 = new OrderItem(0,o1, mi1, 3);

    Optional<OrderItem> orderItemOptional = Optional.of(oi2);
    Mockito.when(oir.findById(oi2.getOrderItemID())).thenReturn(orderItemOptional);
    OrderItem actual = os.getOrderItem(oi2.getOrderItemID());
    Assertions.assertEquals(actual.getOrderItemID(), oi2.getOrderItemID());

    }
//
//
//
//
    @Test
    void deleteOrderItem() {
         Byte[] temp = new Byte [255];
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


        Mockito.doNothing().when(oir).deleteById(oi1.getOrderItemID());

        boolean result = os.deleteOrderItem(oi1.getOrderItemID());
        Assertions.assertTrue(result);
    }
}
