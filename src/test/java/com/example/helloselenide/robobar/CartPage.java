package com.example.helloselenide.robobar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/
public class CartPage {

    // ** ARRIBA *****************************************************************
    // SI expongo los metodos de ABAJO como publicos puedo CONVERTIR estos elementos de PUBLICCOS a PRIVADOS.
    // *******************************************************************

    private SelenideElement btnAddCola = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement btnAddBeer = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement btnAddWine = $("html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

    private SelenideElement txtTotal = $("th[class='ng-binding']");

    private SelenideElement btnCheckOut = $(".btn-success");

    // ** ABAJO *****************************************************************
    // SI expongo estos elementos como publicos puedo mantener los de  arriba como privados.
    // *******************************************************************

    public void addCola() {
        btnAddCola.click();
    }

    public void addBeer() {
        btnAddBeer.click();
    }

    public void addWine() {
        btnAddWine.click();
    }

    public void checkOut(){
        btnCheckOut.click();
    }

    // AÑADIR la CLASSE CartSuiteTest ***************************
    public SelenideElement total() {
        return txtTotal;
    }

    public SelenideElement getCheckOut() {
        return btnCheckOut;
    }
}
