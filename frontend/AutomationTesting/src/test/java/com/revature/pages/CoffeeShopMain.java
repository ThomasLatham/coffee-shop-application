package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoffeeShopMain {
    public WebDriver driver;

    //Fields that represent Elements in the HTML

    //Login
    @FindBy(xpath = "/html/body/app-root/nav/div/div/div/button")
    public WebElement login;

    @FindBy(xpath = "/html/body/app-root/app-login/h3")
    public WebElement loginHeader;

    @FindBy(id = "userInput")
    public WebElement userInput;

    @FindBy(id = "passwordInput")
    public WebElement passwordInput;

    @FindBy(xpath = "/html/body/app-root/app-login/div[2]/div[2]/div/button[1]")
    public WebElement loginBtn;

    @FindBy(id = "loginDiv")
    public WebElement loginDiv;

    @FindBy(xpath = "/html/body/app-root/app-login/div[2]/div[2]/div/button[2]")
    public WebElement registerBtn;

    @FindBy(xpath = "/html/body/app-root/app-landing-page/div[1]/h1")
    public WebElement landingPageHeader;

    @FindBy(id = "accountDiv")
    public WebElement accountDiv;

    @FindBy(xpath = "/html/body/app-root/app-login/div[3]/div/div/form/div[2]/button[1]")
    public WebElement formCloseBtn;

    @FindBy(xpath = "/html/body/app-root/app-login/div[3]/div/div/form/div[2]/button[2]")
    public WebElement formSubmitBtn;

    @FindBy(id = "inputFirstName")
    public WebElement inputFirstName;

    @FindBy(id = "inputLastName")
    public WebElement inputLastName;

    @FindBy(id = "inputPhoneNumber")
    public WebElement inputPhoneNumber;

    @FindBy(id = "inputEmail")
    public WebElement inputEmail;

    @FindBy(id = "inputStreet")
    public WebElement inputStreet;

    @FindBy(id = "inputCity")
    public WebElement inputCity;

    @FindBy(id = "inputZipCode")
    public WebElement inputZipCode;

    @FindBy(id = "inputUsername")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(id = "inputConfirmPassword")
    public WebElement inputConfirmPassword;


    public CoffeeShopMain(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
