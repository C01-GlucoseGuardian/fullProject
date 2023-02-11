package com.glucoseguardian.seleniumtests.dottore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class RegistrazioneDottoreTest {
  private WebDriver driver;
  private final String baseUrl = "http://localhost:8081/";
  private boolean acceptNextAlert = true;

  @BeforeAll
  public static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors");
    driver = new ChromeDriver(options);
  }

  @Test
  public void testTC21() {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).click();
    driver.findElement(By.id("signupCognome")).click();
    driver.findElement(By.id("signupCognome")).clear();
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).click();
    driver.findElement(By.id("signupCodiceFiscale")).clear();
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    driver.findElement(By.id("signupSesso")).click();
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).click();
    driver.findElement(By.id("signupDataNascita")).click();
    driver.findElement(By.id("signupDataNascita")).clear();
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).click();
    driver.findElement(By.id("signupSpecializzazione")).click();
    driver.findElement(By.id("signupSpecializzazione")).clear();
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).click();
    driver.findElement(By.id("signupCodIscAlbo")).clear();
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).click();
    driver.findElement(By.id("signupMail")).clear();
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).click();
    driver.findElement(By.id("signupTelefono")).click();
    driver.findElement(By.id("signupTelefono")).clear();
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).click();
    driver.findElement(By.id("signupNomeStruttura")).clear();
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).click();
    driver.findElement(By.id("signupIndirizzoStruttura")).clear();
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).click();
    driver.findElement(By.id("signupIndirizzo")).clear();
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).click();
    driver.findElement(By.id("signupPassword")).clear();
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupConfirmPassword")).click();
    driver.findElement(By.id("signupConfirmPassword")).clear();
    driver.findElement(By.id("signupConfirmPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    assertEquals("Completa tutti i campi", closeAlertAndGetItsText());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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
}
