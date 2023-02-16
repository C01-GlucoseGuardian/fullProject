package com.glucoseguardian.seleniumtests.dottore;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CambioTerapiaTest extends AbstractSeleniumTest {

  @BeforeEach
  public void login() {
    driver.get(baseUrl + "login/login.html");
    driver.findElement(By.id("email")).sendKeys("dottore@glucoseguardian.it");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("avantilogin")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lista-pazienti")));
    driver.findElement(By.id("lista-pazienti")).click();

    wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-dati-0")));
    driver.findElement(By.id("button-dati-0")).click();

    wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modifica-terapia")));
    driver.findElement(By.id("modifica-terapia")).click();

    wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aggiorna-terapia")));
  }


  @Test
  public void testTC41() throws Exception {
    driver.findElement(By.id("aggiorna-terapia")).click();
    assertEquals("la lista farmaci non può essere vuota", closeAlertAndGetItsText());
  }

  @Test
  public void testTC42() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezideeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    driver.findElement(By.id("dosaggio")).sendKeys("1 mg");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    assertEquals("il nome del farmaco supera il numero massimo di caratteri consentiti", closeAlertAndGetItsText());
  }

  @Test
  public void testTC43() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diamicron");
    driver.findElement(By.id("ora")).sendKeys("13:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("aggiorna-terapia")).click();
    assertEquals("Il campo dosaggio non può essere vuoto", closeAlertAndGetItsText());
  }

  @Test
  public void testTC44() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("2 mg");
    driver.findElement(By.id("ora")).sendKeys("13.00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("aggiorna-terapia")).click();
    assertEquals("Il formato dell'ora non è valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC45() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Gleucos");
    driver.findElement(By.id("dosaggio")).sendKeys("2.5 mg");
    driver.findElement(By.id("ora")).sendKeys("12:00");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("aggiorna-terapia")).click();
    assertEquals("Il campo somministrazione non può essere vuoto", closeAlertAndGetItsText());
  }

  @Test
  public void testTC46() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("2 mg");
    driver.findElement(By.id("ora")).sendKeys("13:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys("da assumere prima di un pastoooooooooooooooooooooooooooooooooooooooooooooooo"
            + "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
            + "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
            + "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
            + "ooooooooooooooooooooooooooooooooooooo");
    driver.findElement(By.id("aggiunta-terapia")).click();
    assertEquals("Il campo note aggiuntive aggiuntive supera i caratteri consentiti", closeAlertAndGetItsText());
    driver.findElement(By.id("aggiorna-terapia")).click();
  }

  @Test
  public void testTC47() throws Exception {
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Dramion");
    driver.findElement(By.id("dosaggio")).sendKeys("3 mg");
    driver.findElement(By.id("ora")).sendKeys("12:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys("da assumere prima di un pasto");
    driver.findElement(By.id("aggiunta-terapia")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("aggiorna-terapia")).click();
    assertEquals("Terapia aggiornata correttamente", closeAlertAndGetItsText());
  }
}
