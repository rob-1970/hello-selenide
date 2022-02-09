package com.example.helloselenide.robobar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class CheckOutPage {

    private SelenideElement ageInput = $("#ageInput" );

    private SelenideElement btnOrderButton = $(".btn-success");


    public void setAgeInput(String age) {
        ageInput.click();
        ageInput.setValue(age);
    }

    public SelenideElement getAgeInput() {
        return ageInput;
    }

    public void checkOut() {
        btnOrderButton.click();
    }


}