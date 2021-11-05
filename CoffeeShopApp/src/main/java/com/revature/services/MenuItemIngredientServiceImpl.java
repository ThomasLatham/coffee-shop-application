package com.revature.services;

import com.revature.models.MenuItemIngredient;
import com.revature.repositories.MenuItemIngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuItemIngredientServiceImpl implements MenuItemIngredientService{

    @Autowired
    MenuItemIngredientRepo miir;

    @Override
    public List<MenuItemIngredient> getAllMenuItemIngredients() {
        return (List<MenuItemIngredient>) miir.findAll();
    }
}
