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
public class DailySpecialServiceTests {
    @Autowired
    DailySpecialService os;

    @MockBean
    DailySpecialRepo dsr;


    @Test
    void getAllDailySpecials() {
        List<DailySpecial> dailySpecialsList = (List<DailySpecial>) dsr.findAll();
        Assertions.assertTrue(dailySpecialsList.isEmpty());
    }



}
