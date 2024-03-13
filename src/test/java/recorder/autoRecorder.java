package recorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.fail;

public class autoRecorder {
    public WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();
  public WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver", "C://Users//user//Desktop//все//" +
              "chromedriver-win32//chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://vkusvill.ru/");
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testUntitledTestCase() throws Exception {
      enter();
      login(wait);
      password(wait);
    }

  private void password(WebDriverWait wait) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-sms-title")));
    driver.findElement(By.name("SMS")).sendKeys("100500");
    driver.findElement(By.xpath("//div[@id='js-spinner-common']/span")).click();
  }

  private void login(WebDriverWait wait) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-user-form-container-login-title")));
    driver.findElement(By.name("USER_PHONE")).click();
    driver.findElement(By.name("USER_PHONE")).sendKeys("8889996666");
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='js-user-form-login-api']/div[5]/button")));
    button.click();
  }

  private void enter() {
    driver.findElement(By.linkText("Войти")).click();
  }

  @After
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!verificationErrorString.isEmpty()) {
        fail(verificationErrorString);
      }
    }
  }
