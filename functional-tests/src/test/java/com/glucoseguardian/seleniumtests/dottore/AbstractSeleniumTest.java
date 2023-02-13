package com.glucoseguardian.seleniumtests.dottore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AbstractSeleniumTest {
  protected final String baseUrl = "http://localhost:8081/";
  protected WebDriver driver;
  private boolean acceptNextAlert = true;

  @BeforeAll
  public static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless", "--window-size=1920,1080", "--ignore-certificate-errors");
    driver = new ChromeDriver(options);
  }

  protected String closeAlertAndGetItsText() throws Exception {
    try {
      Alert alert = waitForAlert(driver);
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  private Alert waitForAlert(WebDriver driver) throws Exception {
    for (int i = 0; i < 100; i++) {
      try {
        return driver.switchTo().alert();
      } catch (NoAlertPresentException e) {
        Thread.sleep(100);
      }
    }
    throw new NoAlertPresentException();
  }
}
