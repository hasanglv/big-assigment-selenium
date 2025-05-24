package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By welcomeTitle = By.xpath("//h1[contains(text(),'Welcome!')]");
    private By homeLink = By.id("home");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getWelcomeTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeTitle)).getText();
    }

    // New method to click the Home link
    public void clickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }
}
