package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.models.*;
import com.revature.services.OrderService;
import com.revature.services.PictureService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class PictureControllerTest {

    @MockBean
    PictureService ps;

    @Autowired
    MockMvc mvc;
    Gson gson = new Gson();

    Byte[] temp = new Byte [255];
    Picture p = new Picture(1,"shop",temp);
    Shop s = new Shop(1, "shop", p);

    @Test
    void getPictureById() throws Exception {
        Mockito.when(ps.getPicture(1)).thenReturn(new Picture(1, "Coffee",temp));

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/picture/1"));

        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void addPicture() throws Exception {
        Mockito.when(ps.addPicture(p)).thenReturn(p);
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.post("/picture").content(new ObjectMapper().writeValueAsString(p)).contentType(MediaType.APPLICATION_JSON_VALUE));
        ra.andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    void getAllPicturess() throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/pictures"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deletePicture() throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.delete("/picture/1",1));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
