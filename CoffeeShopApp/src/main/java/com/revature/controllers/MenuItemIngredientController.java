package com.revature.controllers;

import com.revature.models.MenuItemIngredient;
import com.revature.services.MenuItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MenuItemIngredientController {

    @Autowired
    MenuItemIngredientService miis;

    @GetMapping("/MenuItemIngredients")
    public List<MenuItemIngredient> getAllMenuItemIngredients() {
        return miis.getAllMenuItemIngredients();
    }
}
