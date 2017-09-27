package com.lightside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vellial on 27.09.2017.
 */
public class Login {
    // Rebekka_13W
    // anneli.devel@mail.ru

    WebDriver driver;
    By username = By.id("mailbox__login");
    By password = By.id("mailbox__password");
    By submit = By.id("mailbox__auth__button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(username).sendKeys(userName);
    }

    public void setPassword(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }

    public void clickLogin() {
        driver.findElement(submit).click();
    }

    public void loginToMail(String username, String password) {
        setUserName(username);
        setPassword(password);
        clickLogin();
    }
}
