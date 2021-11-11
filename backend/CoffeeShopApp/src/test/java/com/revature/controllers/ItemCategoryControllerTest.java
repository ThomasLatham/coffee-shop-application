package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.*;
import com.revature.services.ItemCategoryService;
import com.revature.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class ItemCategoryControllerTest {
    @MockBean
    ItemCategoryService os;
    @Autowired
    MockMvc mvc;

    @Test
    void getAllItemCategories() throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/itemCategories"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }
}