package com.example.helloselenide.robobar;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.helloselenide.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RoboBarTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/#!/#%2F");
    }

    @Test
    public void imdbsearch() {
/*        mainPage.searchButton.click();

        $("[data-test='search-input']").sendKeys("Selenium");
        $("button[data-test='full-search-button']").click();

        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));*/

        // Ja tenim configurada la pagina sobre la que volem realitzar les PROVES.
        //         driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        //$("#suggestion-search").sendKeys("el juego del calamar", Keys.ENTER);

        //        assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€1.25"));
        //        driver.findElement(By.cssSelector(".btn-success")).click();
        //$(By.linkText("Squid Game")).shouldBe(visible).click();

    }

    /*@Test
    public void toolsMenu() {
        mainPage.toolsMenu.hover();

        $("div[data-test='menu-main-popup-content']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }*/
}
