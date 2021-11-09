package com.revature.controllers;

import com.revature.models.*;
import com.revature.repositories.*;
import com.revature.services.OrderItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class OrderItemControllerTests {
    @MockBean
    OrderItemService as;

    @Autowired
    MockMvc mvc;

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
    void getOrderItem() throws Exception {
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


        Mockito.when(as.getOrderItem(1)).thenReturn(new OrderItem(1,o1, mi1, 2));

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/orderItems/1"));

        ra.andExpect(status().isOk());


    }
}
