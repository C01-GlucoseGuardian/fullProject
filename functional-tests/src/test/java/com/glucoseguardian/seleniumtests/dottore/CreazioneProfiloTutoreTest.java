package com.glucoseguardian.seleniumtests.dottore;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreazioneProfiloTutoreTest extends AbstractSeleniumTest {

  @BeforeEach
  public void login() {
    driver.get(baseUrl + "login/login.html");
    driver.findElement(By.id("email")).sendKeys("dottore@glucoseguardian.it");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("avantilogin")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-tutore")));
    driver.findElement(By.id("new-tutore")).click();
    wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cognome")));
  }

  @Test
  public void testTC3_1() throws Exception {
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("La lunghezza del nome non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_2() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardo");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("La lunghezza del cognome non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_3() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardo");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10HHH501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("La lunghezza del codice fiscale deve essere di 16 caratteri",
        closeAlertAndGetItsText());
  }


  @Test
  public void testTC3_4() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Gianni");
    driver.findElement(By.id("cognome")).sendKeys("Otto");
    driver.findElement(By.id("codiceFiscale")).sendKeys("TTOGNN65M07G273H");
    driver.findElement(By.id("dataNascita")).sendKeys("07/08/1965");
    driver.findElement(By.id("email")).sendKeys("tutore@glucoseguardian.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("Palermo Corso Vittorio Emanuele 10");

    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("Codice fiscale già presente nel database", closeAlertAndGetItsText());
  }


  @Test
  public void testTC3_5() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Sesso");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("il sesso non è valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_6() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/0687/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("la data nascita inserita non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC3_7() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/6001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("La data di nascita è nel futuro", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_8() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGTVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vitopiegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("L'email non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_9() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("tutore@glucoseguardian.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("Email già presente nel database", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_10() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardo");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("36f2324kjkk");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("il campo numero di telefono non rispetta il formato", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_11() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardo");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys(
        "C.so Garibaldi, 12 22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222rrwasd22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("La lunghezza dell'indirizzo non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC3_12() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardi");
    driver.findElement(By.id("cognome")).sendKeys("Piegari");
    driver.findElement(By.id("nome")).sendKeys("Vito Gerardo");
    driver.findElement(By.id("codiceFiscale")).sendKeys("PGRVGR01L10H501U");
    driver.findElement(By.id("dataNascita")).sendKeys("10/07/2001");
    driver.findElement(By.id("email")).sendKeys("vito@piegari.it");
    driver.findElement(By.id("telefono")).sendKeys("3663212456");
    driver.findElement(By.id("indirizzo")).sendKeys("C.so Garibaldi, 12");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("crea-button")).click();

    assertEquals("Tutore inserito correttamente", closeAlertAndGetItsText());
  }


  @AfterEach
  public void tearDown() {
    driver.quit();
  }


}
