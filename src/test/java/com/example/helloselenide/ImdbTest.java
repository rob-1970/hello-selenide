package com.example.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImdbTest {
    //MainPage mainPage = new MainPage();     // NO FA FALTA

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.imdb.com/");
    }

    @Test
    public void imdbsearch() {
/*        mainPage.searchButton.click();

        $("[data-test='search-input']").sendKeys("Selenium");
        $("button[data-test='full-search-button']").click();

        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));*/

        // Ja tenim configurada la pagina sobre la que volem realitzar les PROVES.
        //        driver.findElement(By.id("suggestion-search")).sendKeys("el juego del calamar");
        $("#suggestion-search").sendKeys("el juego del calamar", Keys.ENTER);
        //        assertThat(driver.findElement(By.xpath("//h1")).getText(), is("Squid Game"));
        $(By.linkText("Squid Game")).shouldBe(visible).click();

    }

    // REVISAR estos TESTs para solucionarlo y que funcionen
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
