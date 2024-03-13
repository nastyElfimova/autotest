package ru.vkusvill;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {
  ChromeDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C://Users//user//Desktop//все//" +
            "chromedriver-win32//chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void authorization() {
    driver.get("https://vkusvill.ru/");

    String title = driver.getTitle();
    Assert.assertTrue(title.equals("ВкусВилл — интернет-магазин продуктов для здорового питания с доставкой на дом | Москва и вся Россия"));

    WebElement link = driver.findElement(By.cssSelector(".HeaderMain__Col._btn._profile.HeaderDropdown.js-vv23-header-dropdown"));
    link.findElement(By.cssSelector("[href=\"javascript:void(0)\"]")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-container-login-title")));

    WebElement phone = driver.findElement(By.name("USER_PHONE"));
    phone.sendKeys("8889996666");

    WebElement button = driver.findElement(By.cssSelector(".VV_AuthModal20FSForm__Item._btnWrp"));
    button.findElement(By.cssSelector("[type =\"submit\"]")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-sms-title")));

    WebElement password = driver.findElement(By.name("SMS"));
    password.sendKeys("100500");

    WebElement entrance = driver.findElement(By.cssSelector(".UniversMainIcBtn__Text.btn_text._desktop-md"));
  }

  @After
  public void out() {
    driver.quit();
  }
  }

