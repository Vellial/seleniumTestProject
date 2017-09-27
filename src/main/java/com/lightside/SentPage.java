package com.lightside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vellial on 27.09.2017.
 */
public class SentPage {
    WebDriver driver;
    By sentDiv = By.xpath("//*[@id=\"b-compose__sent\"]/div/div[1]/div");

    public SentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSentPageProperty() {
        return driver.findElement(sentDiv).getText();
    }
}
