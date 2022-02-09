package com.example.helloselenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class RoboOrderPage {

    private SelenideElement alertAge = $(".alert-danger");

    private SelenideElement orderSent = $("p");

    public SelenideElement getAlertAge() {
        return alertAge;
    }

    public SelenideElement getOrderSent() {
        return orderSent;
    }

}