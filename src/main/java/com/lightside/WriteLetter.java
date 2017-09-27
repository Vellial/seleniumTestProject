package com.lightside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vellial on 27.09.2017.
 */
public class WriteLetter {
    WebDriver driver;
    By writeLetterBtn = By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span");
    By to = By.cssSelector("textarea[data-original-name='To']");
    By sendBtn = By.cssSelector("div[data-name='send']");

    public WriteLetter(WebDriver driver) {
        this.driver = driver;
    }

    public void setTo(String to) {
        driver.findElement(this.to).sendKeys(to);
    }

    public void setBody(String bodytext) {
        driver.switchTo().frame(driver.findElement(By.className("mceIframeContainer")).findElement(By.tagName("iframe")));
        WebElement body = driver.findElement(By.tagName("body"));
        body.clear();
        body.sendKeys(bodytext);
        driver.switchTo().defaultContent();
    }

    public void clickWrite() {
        driver.findElement(writeLetterBtn).click();
    }

    public void clickSend() {
        driver.findElement(sendBtn).click();
    }

    public void writeLetter(String to, String body) {
        clickWrite();
        setTo(to);
        setBody(body);
        clickSend();
    }

}
