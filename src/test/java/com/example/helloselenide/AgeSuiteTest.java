package com.example.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AgeSuiteTest {
    CartPage cartPage = new CartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    RoboOrderPage orderPage = new RoboOrderPage();

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
    public void underageCola() {
        // Test name: UnderageCola
        // Step # | name | target | value
        // 1 | open | / |
        //driver.get("http://localhost:3000/");
        // 2 | click | css=.ng-scope:nth-child(1) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        //cartPage.addColaButton.click();
        cartPage.addCola();
        // 3 | assertText | css=tr:nth-child(4) > .ng-binding | €1.25
        // 1x RobaCola = €1.25
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€1.25"));
        //assertThat(cartPage.totalField.getText(), is("€1.25"));
        cartPage.total().shouldBe(text("€1.25"));
        // 4 | click | css=.ng-scope:nth-child(1) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        //cartPage.addColaButton.click();
        cartPage.addCola();
        // 5 | assertText | css=tr:nth-child(4) > .ng-binding | €2.50
        // 2x RobaCola = €2.50
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€2.50"));
        //assertEquals(cartPage.totalField.getText(), "€2.50");
        cartPage.total().shouldBe(text("€2.50"));
        // 6 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //cartPage.checkoutButton.click();
        cartPage.checkOut();
        // 7 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //checkoutPage.orderButton.click();
        checkOutPage.checkOut();
        // 8 | assertText | css=p | Coming right up! ~bzzzt~
        //assertThat(driver.findElement(By.cssSelector("p")).getText(), is("Coming right up! ~bzzzt~"));
        //assertThat(orderPage.confirmationMessage.getText(), is("Coming right up! ~bzzzt~"));
        orderPage.getOrderSent().shouldBe(text("Coming right up! ~bzzzt~"));
    }

    @Test
    public void underageBeer() {
        // Test name: UnderageBeer
        // Step # | name | target | value
        // 1 | open | / |
        //driver.get("http://localhost:3000/");
        // 2 | click | css=.ng-scope:nth-child(2) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        //cartPage.addBeerButton.click();
        cartPage.addBeer();
        // 3 | assertText | css=tr:nth-child(4) > .ng-binding | €2.00
        // 1x RoboBeer = €2.00
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€2.00"));
        //assertThat(cartPage.totalField.getText(), is("€2.00"));
        cartPage.total().shouldBe(text("€2.00"));
        // 4 | click | css=.ng-scope:nth-child(2) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        //cartPage.addBeerButton.click();
        cartPage.addBeer();
        // 5 | assertText | css=tr:nth-child(4) > .ng-binding | €4.00
        // 2x RoboBeer = €4.00
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€4.00"));
        //assertThat(cartPage.totalField.getText(), is("€4.00"));
        cartPage.total().shouldBe(text("€4.00"));
        // 6 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //cartPage.checkoutButton.click();
        cartPage.checkOut();
        // 7 | mouseOver | css=.btn-success |
        /*{
            WebElement element = driver.findElement(By.cssSelector(".btn-success"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }*/
        // 8 | click | id=ageInput |
        //driver.findElement(By.id("ageInput")).click();
        //checkoutPage.ageInput.click();

        // 9 | type | id=ageInput | 17
        //driver.findElement(By.id("ageInput")).sendKeys("17");
        //checkoutPage.ageInput.sendKeys("19");
        checkOutPage.setAgeInput("17");
        // 10 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //checkoutPage.orderButton.click();
        checkOutPage.checkOut();
        // 11 | assertElementPresent | css=.alert-danger |
        /*{
            List<WebElement> elements = driver.findElements(By.cssSelector(".alert-danger"));
            assert (elements.size() > 0);
        }*/
        //assertThat(orderPage.confirmationMessage.getText(), is("Coming right up! ~bzzzt~"));
        assertThat(orderPage.getAlertAge().isDisplayed(), is(true));
     }

    @Test
    public void adultBeer() {
        // Test name: AdultBeer
        // Step # | name | target | value
        // 1 | open | / |
        //driver.get("http://localhost:3000/");
        // 2 | click | css=.ng-scope:nth-child(2) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        //cartPage.addBeerButton.click();
        cartPage.addBeer();
        // 3 | assertText | css=tr:nth-child(4) > .ng-binding | €2.00
        // 1x RoboBeer = €2.00
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€2.00"));
        //assertThat(cartPage.totalField.getText(), is("€2.00"));
        cartPage.total().shouldBe(text("€2.00"));
        // 4 | click | css=.ng-scope:nth-child(2) > td .input-group-append > .btn |
        //driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        //cartPage.addBeerButton.click();
        cartPage.addBeer();
        // 5 | assertText | css=tr:nth-child(4) > .ng-binding | €4.00
        // 2x RoboBeer = €4.00
        //assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText(), is("€4.00"));
        //assertThat(cartPage.totalField.getText(), is("€4.00"));
        cartPage.total().shouldBe(text("€4.00"));
        // 6 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //cartPage.checkoutButton.click();
        cartPage.checkOut();
        // 7 | mouseOver | css=.btn-success |
        /*{
            WebElement element = driver.findElement(By.cssSelector(".btn-success"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }*/
        // 8 | click | id=ageInput |
        //driver.findElement(By.id("ageInput")).click();
        //checkoutPage.ageInput.click();

        // 9 | type | id=ageInput | 19
        //driver.findElement(By.id("ageInput")).sendKeys("19");
        //checkoutPage.ageInput.sendKeys("19");
        checkOutPage.setAgeInput("18.1");
        // 10 | click | css=.btn-success |
        //driver.findElement(By.cssSelector(".btn-success")).click();
        //checkoutPage.orderButton.click();
        checkOutPage.checkOut();
        // 11 | assertText | css=p | Coming right up! ~bzzzt~
        //assertThat(driver.findElement(By.cssSelector("p")).getText(), is("Coming right up! ~bzzzt~"));
        //assertThat(orderPage.confirmationMessage.getText(), is("Coming right up! ~bzzzt~"));
        orderPage.getOrderSent().shouldBe(text("Coming right up! ~bzzzt~"));
    }

    @Test
    public void adultColaSelenide() {
        cartPage.addCola();
        cartPage.checkOut();
        checkOutPage.getAgeInput();
    }
}
