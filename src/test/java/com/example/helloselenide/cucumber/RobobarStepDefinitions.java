package com.example.helloselenide.cucumber;

import com.example.helloselenide.robobar.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;
    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http//localhost:3000");
    }

    @When("user add a cola")
    public void userAddACola() {
    //    CartPage cartPage = new CartPage();
        cartPage.addCola();
    }

    @Then("total should be €{double}")
    public void totalShouldBe€(Double total) {
        cartPage.total().shouldBe(exactText("€"+total.toString()));
    }
}
