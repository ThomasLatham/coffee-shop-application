package com.revature.services;

import com.revature.models.DailySpecial;
import com.revature.models.MenuItem;
import com.revature.repositories.DailySpecialRepo;
import com.revature.repositories.MenuItemRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class MenuItemServiceTests {
    @Autowired
    MenuItemService os;

    @MockBean
    MenuItemRepo mir;


    @Test
    void getAllMenuItems() {
        List<MenuItem> menuItemList = (List<MenuItem>) mir.findAll();
        Assertions.assertTrue(menuItemList.isEmpty());
    }


}
