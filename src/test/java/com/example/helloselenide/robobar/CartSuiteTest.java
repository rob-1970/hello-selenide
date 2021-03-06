package com.example.helloselenide.robobar;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.helloselenide.robobar.CartPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartSuiteTest {
    CartPage cartPage =  new CartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/");
    }

    @Test
    public void colaTest() {
        cartPage.addCola();
        cartPage.total().shouldBe(text("€1.25"));
        cartPage.addCola();
        cartPage.total().shouldBe(text("€2.50"));
    }

    // Hacer lo mismo co 1 o 2 cervezas
    @Test
    public void beerTest() {
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€2.00"));
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€4.00"));
    }
}
