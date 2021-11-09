package com.revature.steps;

import com.revature.pages.CoffeeShopMain;
import com.revature.runners.CoffeeShopRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepImpl {
    public static CoffeeShopMain coffeeShop = CoffeeShopRunner.CoffeeShop;
    public static WebDriver driver = CoffeeShopRunner.driver;

    @Given("the user is on about us page")
    public void the_user_is_on_about_us_page() {
        driver.get("http://");
    }
    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user is on login page")
    public void the_user_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is on the login page' and 3 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("clicks on the sign in button")
    public void clicks_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user sign in, then logout button and username shows up, the register now button disappear")
    public void the_user_sign_in_then_logout_button_and_username_shows_up_the_register_now_button_disappear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is on the login page' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the error message shows up and the invalid Texts are removed")
    public void the_error_message_shows_up_and_the_invalid_texts_are_removed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is logged in' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user logout, the login button shows up")
    public void the_user_logout_the_login_button_shows_up() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is on the login page' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the register now button")
    public void the_user_clicks_on_the_register_now_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the create account window shows up")
    public void the_create_account_window_shows_up() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is on the register window' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is on the register window")
    public void the_user_is_on_the_register_window() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the close button")
    public void the_user_clicks_on_the_close_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the create account window disappear")
    public void the_create_account_window_disappear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    io.cucumber.junit.UndefinedStepException: The step 'the user is on the register window' and 2 other step(s) are undefined.
    You can implement these steps using the snippet(s) below:

    @Given("the user is on the register window")
    public void the_user_is_on_the_register_window() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the submit button with all valid inputs")
    public void the_user_clicks_on_the_submit_button_with_all_valid_inputs() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the new account be created and the user sign in.")
    public void the_new_account_be_created_and_the_user_sign_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
