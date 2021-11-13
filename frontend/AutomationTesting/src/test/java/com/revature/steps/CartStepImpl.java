package com.revature.steps;

import com.revature.pages.CartPage;
import com.revature.pages.CoffeeShopMain;
import com.revature.pages.MenuPage;
import com.revature.pages.OrderManagementPage;
import com.revature.runners.CoffeeShopRunner;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartStepImpl {

    public static MenuPage menuPage = CoffeeShopRunner.menuPage;
    public static CartPage cartPage = CoffeeShopRunner.cartPage;
    public static OrderManagementPage orderManagementPage = CoffeeShopRunner.orderManagementPage;
    public static WebDriver driver = CoffeeShopRunner.driver;


    @Given("The User is not logged in")
    public void the_user_is_not_logged_in() {

        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        driver.navigate().refresh();
    }

    @Given("The User's cart is empty")
    public void the_user_s_cart_is_empty() {

        driver.manage().window().maximize();
        driver.get("http://localhost:4200");
        driver.navigate().refresh();
    }

    @Given("The User is on the Cart Page")
    public void the_user_is_on_the_cart_page() {

        driver.manage().window().maximize();
        driver.get("http://localhost:4200/cart");
    }

    @Then("The Submit Order button will be replaced by a message prompting the User to sign in")
    public void the_submit_order_button_will_be_replaced_by_a_message_prompting_the_user_to_sign_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("The User is logged in")
    public void the_user_is_logged_in() {

        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login");
        orderManagementPage.userInput.sendKeys("coffeequeen92");
        orderManagementPage.passwordInput.sendKeys("Password1");
        orderManagementPage.loginBtn.click();
        new WebDriverWait(driver, 10L);
    }

    @Then("The Submit Order button will replaced by a message prompting the User to add items to their cart")
    public void the_submit_order_button_will_replaced_by_a_message_prompting_the_user_to_add_items_to_their_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("The User's cart is not empty")
    public void the_user_s_cart_is_not_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The User clicks the Remove From Cart button")
    public void the_user_clicks_the_remove_from_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("That item is no longer in the cart")
    public void that_item_is_no_longer_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The User clicks the Increase Quantity button")
    public void the_user_clicks_the_increase_quantity_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The Quantity of that item increases by one")
    public void the_quantity_of_that_item_increases_by_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The User clicks the Decrease Quantity button")
    public void the_user_clicks_the_decrease_quantity_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The Quantity of that item decreases by one")
    public void the_quantity_of_that_item_decreases_by_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The User selects Delivery")
    public void the_user_selects_delivery() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Delivery is selected")
    public void delivery_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The User clicks the Submit Order button")
    public void the_user_clicks_the_submit_order_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The User is redirected to the Landing Page")
    public void the_user_is_redirected_to_the_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    //helper methods

    private void loginSequence() {


    }

}
