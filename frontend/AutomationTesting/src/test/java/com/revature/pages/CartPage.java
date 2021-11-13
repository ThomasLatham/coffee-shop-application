package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/app-cart/div/table[1]/tr[2]/td[2]/span")
    public WebElement cartItem1Text;

    @FindBy(xpath = "/html/body/app-root/app-cart/div/table[1]/tr[2]/td[2]/p/span[1]")
    public WebElement extraItem1Text;

    public CartPage (WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
