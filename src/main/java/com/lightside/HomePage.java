package com.lightside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vellial on 27.09.2017.
 */
public class HomePage {
    WebDriver driver;
    By homepageName = By.xpath(".//*[@id='b-nav_folders']/div/div[1]/a/span[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageProperty() {
        return driver.findElement(homepageName).getText();
    }
}
