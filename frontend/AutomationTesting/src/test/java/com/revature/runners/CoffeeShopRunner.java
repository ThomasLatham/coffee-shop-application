package com.revature.runners;

import com.revature.pages.CoffeeShopMain;

//This class is responsible for Running the Tests by pulling in the
//feature files and step implementations and executing them
//appropriately

import com.revature.pages.CoffeeShopMain;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"com.revature.steps"})
public class CoffeeShopRunner {

    public static WebDriver driver;
    public static  CoffeeShopMain CoffeeShop;

    @BeforeClass
    public static void setUp() {
        String path = System.getenv("DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        CoffeeShop = new CoffeeShopMain(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

