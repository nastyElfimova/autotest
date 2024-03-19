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
import common.TestData;


public class FirstTest {
  ChromeDriver driver;
  WebDriverWait wait;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @Test
  public void authorization() {
    driver.get(TestData.WEBSITE_URL);

    String title = driver.getTitle();
    Assert.assertTrue(title.equals("ВкусВилл — интернет-магазин продуктов для здорового питания с доставкой на дом | Москва и вся Россия"));

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href=\"javascript:void(0)\"]"))).click();


    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-container-login-title")));

    WebElement phone = driver.findElement(By.name("USER_PHONE"));
    phone.sendKeys(TestData.PHONE_NUMBER);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='js-user-form-login-api']/div[5]/button"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-sms-title")));


    WebElement password = driver.findElement(By.name("SMS"));
    password.sendKeys(TestData.PASSWORD);

    driver.findElement(By.cssSelector(".UniversMainIcBtn__Text.btn_text._desktop-md"));
  }

  @After
  public void out() {

    driver.quit();
  }
 }

