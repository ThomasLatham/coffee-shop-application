package com.revature.services;

import com.revature.models.MenuItemIngredient;
import com.revature.repositories.MenuItemIngredientRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(classes = com.revature.app.CoffeeShopAppApplication.class)
public class MenuItemIngredientServiceTests {
    @Autowired
    MenuItemIngredientService os;

    @MockBean
    MenuItemIngredientRepo miir;


    @Test
    void getAllMenuItemIngredients() {
        List<MenuItemIngredient> menuItemIngredientList = (List<MenuItemIngredient>) miir.findAll();
        Assertions.assertTrue(menuItemIngredientList.isEmpty());
    }


}
