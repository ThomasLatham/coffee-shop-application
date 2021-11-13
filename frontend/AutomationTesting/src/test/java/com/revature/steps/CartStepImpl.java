package com.revature.steps;

import com.revature.pages.CartPage;
import com.revature.pages.CoffeeShopMain;
import com.revature.pages.MenuPage;
import com.revature.runners.CoffeeShopRunner;
import org.openqa.selenium.WebDriver;

public class CartStepImpl {

    public static CoffeeShopMain loginPage = CoffeeShopRunner.CoffeeShop;
    public static MenuPage menuPage = CoffeeShopRunner.menuPage;
    public static CartPage cartPage = CoffeeShopRunner.cartPage;
    public static WebDriver driver = CoffeeShopRunner.driver;

}
