package com.revature.runners;

//This class is responsible for Running the Tests by pulling in the
//feature files and step implementations and executing them
//appropriately

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

    @BeforeClass
    public static void setUp() {
        String path = "C:/Users/tlath/OneDrive/Documents/Revature/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

