package com.example.helloselenide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://localhost:3000/#!/review
public class OrderPageInitial {

    @FindBy(css = ".alert-danger")
    public WebElement alertDiv;

    @FindBy(css = "p")
    public WebElement confirmationMessage;

    public OrderPageInitial(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}