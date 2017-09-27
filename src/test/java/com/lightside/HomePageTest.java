package com.lightside;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vellial on 27.09.2017.
 */
public class HomePageTest {
    WebDriver driver;
    Login login;
    HomePage homePage;
    WriteLetter writeLetter;
    SentPage sentPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\geckodriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");
    }

    @Test(priority = 0)
    public void test_Login() {
        login = new Login(driver);
        login.loginToMail("anneli.devel", "Rebekka_13W");
        homePage = new HomePage(driver);
        boolean test = false;
        try {
            test = homePage.getHomePageProperty().toLowerCase().contains("входящие");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            test = homePage.getHomePageProperty().toLowerCase().contains("входящие");
        }
        Assert.assertTrue(test);
    }

    @Test
    public void test_WriteLetter() {
        writeLetter = new WriteLetter(driver);
        writeLetter.writeLetter("lost.life.omsk@gmail.com", "Hello! This is selenium test mail");
        sentPage = new SentPage(driver);
        boolean test = false;
        try {
            test = sentPage.getSentPageProperty().toLowerCase().contains("отправлено");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            test = sentPage.getSentPageProperty().toLowerCase().contains("отправлено");
        }
        Assert.assertTrue(test);
    }
}