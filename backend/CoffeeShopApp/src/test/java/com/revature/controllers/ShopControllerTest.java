package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.models.*;
import com.revature.services.OrderService;
import com.revature.services.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class ShopControllerTest {
    @MockBean
    ShopService ss;

    @Autowired
    MockMvc mvc;
    Gson gson = new Gson();

    Byte[] temp = new Byte [255];
    Picture p = new Picture(1,"shop",temp);
    Shop s = new Shop(1, "shop", p);

    @Test
    void getShopById() throws Exception {
        Mockito.when(ss.getShop(1)).thenReturn(new Shop(1,s.getShopLocation(),s.getShopPic()));

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shop/1"));

        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void addShop() throws Exception {
        Mockito.when(ss.addShop(s)).thenReturn(s);
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.post("/shop").content(new ObjectMapper().writeValueAsString(s)).contentType(MediaType.APPLICATION_JSON_VALUE));
        ra.andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void getAllshops() throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shops"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteShop() throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.delete("/shops/1",1));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
