package com.example.helloselenide.cucumber;

import com.example.helloselenide.robobar.CartPage;
import com.example.helloselenide.robobar.CheckOutPage;
import com.example.helloselenide.robobar.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    // AFEGIR en general la linia 24
    private CartPage cartPage;
    private CheckOutPage checkoutPage;
    private OrderPage orderPage;

    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
        //open("http://localhost:3000");
        // AFEGIR en general la linia 24
        cartPage = new CartPage();
    }

    @When("user add a cola")
    public void userAddACola() {
    //    CartPage cartPage = new CartPage();
        cartPage.addCola();
    }

    @When("user add a beer")
    public void userAddABeer() {
        cartPage.addBeer();
    }

    @Then("total should be €{double}")
    public void totalShouldBe€(Double total) {
        cartPage.total().shouldBe(exactText(String.format("€%.2f",total)));
    }

    @When("user press submit button")
    public void userPressSubmitButton() {
        cartPage.checkOut();
        checkoutPage = new CheckOutPage();
    }

    @When("user enter her age is {int}")
    public void userEnterHerAgeIs(int arg0) {
        // checkoutPage.setAgeInput("17");       INICIALMENT funciona OK pero nomes per 17 o 20
        // checkoutPage.setAgeInput("20");
        checkoutPage.setAgeInput(String.valueOf(arg0));
    }

    @When("user press order button")
    public void userPressOrderButton() {
        checkoutPage.checkOut();
        orderPage = new OrderPage();
    }

    @Then("alert is active")
    public void alertIsActive() {
        orderPage.getAlertAge().shouldNotBe(hidden);
    }

    @Then("alert is not active")
    public void alertIsNotActive() {
        orderPage.getAlertAge().shouldBe(hidden);
    }

    @And("order is confirmed")
    public void orderIsConfirmed() {
        //orderPage = checkoutPage.checkOut();
        orderPage.getAlertAge().shouldBe(hidden);
        orderPage.getOrderSent().shouldBe(text("Coming right up! ~bzzzt~"));
    }
}
