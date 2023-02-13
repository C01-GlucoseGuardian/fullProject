package com.glucoseguardian.seleniumtests.dottore;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreazioneProfiloPazienteTest extends AbstractSeleniumTest {

  @BeforeEach
  public void login() {
    driver.get(baseUrl + "login/login.html");
    driver.findElement(By.id("email")).sendKeys("dottore@glucoseguardian.it");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("avantilogin")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-paziente")));
    driver.findElement(By.id("new-paziente")).click();

    wait = new WebDriverWait(driver, Duration.of(30, SECONDS));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cognome")));
  }

  @Test
  public void testTC51() throws Exception {
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza del campo nome non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC52() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza del cognome non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC53() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963YQ");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza del codice fiscale deve essere di 16 caratteri",
        closeAlertAndGetItsText());
  }

  @Test
  public void testTC54() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Martina");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("MRTLDA01L55C514M");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Femmina");
    driver.findElement(By.id("dataNascita")).sendKeys("15/07/2001");
    driver.findElement(By.id("email")).sendKeys("paziente2@glucoseguardian.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Cerignola, Via San Samuele 10");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("Numero Farmaci non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC55() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("il sesso non è valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC56() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/20010");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("la data nascita inserita non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC57() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/3000");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La data di nascita è nel futuro", closeAlertAndGetItsText());
  }

  @Test
  public void testTC58() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldihotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("L'email non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC59() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("paziente@glucoseguardian.it");
    driver.findElement(By.id("telefono")).sendKeys("3938776542");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("Numero Farmaci non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC510() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894444444444");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("il campo numero di telefono non rispetta il formato", closeAlertAndGetItsText());
  }

  @Test
  public void testTC511() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys(
        "Caserta Via Vico 1 ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza dell'indirizzo non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC512() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys(
        "3911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894391169789439116978943911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("campo numeri utili non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC513() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("39116978o94");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("campo numeri utili non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC514() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys(
        "Tipo 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza del tipo diabete non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC515() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("comorbilita")).sendKeys(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza della commorbilità non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC516() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("farmaciAssunti")).sendKeys(
        "DiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezide");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza di farmaci assunti non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC517() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    for (int i=0; i < 21; i++) {
      driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
      driver.findElement(By.id("dosaggio")).sendKeys("1");
      driver.findElement(By.id("ora")).sendKeys("20:00");
      driver.findElement(By.id("somministrazione")).sendKeys("orale");
      driver.findElement(By.id("aggiunta-terapia")).click();
    }
    driver.findElement(By.id("crea-button")).click();
    assertEquals("Numero Farmaci non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC518() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys(
        "DiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezideDiabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    assertEquals("il nome del farmaco supera il numero massimo di caratteri consentiti",
        closeAlertAndGetItsText());
  }

  @Test
  public void testTC519() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio"))
        .sendKeys("1001ababababababa1001ababababababa1001ababababababa1001ababababababa");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza del dosaggio è errata", closeAlertAndGetItsText());
  }

  @Test
  public void testTC520() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:000");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("aggiunta-terapia")).click();
    assertEquals("Il formato dell'ora non è valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC521() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys(
        "oraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleoraleorale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys("Nulla");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("crea-button")).click();
    assertEquals("La lunghezza della via di somministrazione è errata", closeAlertAndGetItsText());
  }


  @Test
  public void testTC522() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("14");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys(
        "NullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullaNullavNullaNullaNullaNullaNullaNullaNullaNullaNulla");
    driver.findElement(By.id("aggiunta-terapia")).click();
    assertEquals("Il campo note aggiuntive aggiuntive supera i caratteri consentiti", closeAlertAndGetItsText());
  }

  @Test
  public void testTC523() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("-1");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys("Nulla");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("crea-button")).click();
    assertEquals("periodo di monitoraggio non valido", closeAlertAndGetItsText());
  }

  @Test
  public void testTC524() throws Exception {
    driver.findElement(By.id("nome")).sendKeys("Matteo");
    driver.findElement(By.id("cognome")).sendKeys("Aldi");
    driver.findElement(By.id("codiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("sesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("dataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("email")).sendKeys("matteo..aldi@hotmail.it");
    driver.findElement(By.id("telefono")).sendKeys("3911697894");
    driver.findElement(By.id("indirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("numeriUtili")).sendKeys("3911697894");
    driver.findElement(By.id("tipoDiabete")).sendKeys("Tipo 1");
    driver.findElement(By.id("periodoMonitoraggio")).sendKeys("1");
    driver.findElement(By.id("nomeFarmaco")).sendKeys("Diabrezide");
    driver.findElement(By.id("dosaggio")).sendKeys("1");
    driver.findElement(By.id("ora")).sendKeys("20:00");
    driver.findElement(By.id("somministrazione")).sendKeys("orale");
    driver.findElement(By.id("noteAggiuntive")).sendKeys("Nulla");
    driver.findElement(By.id("aggiunta-terapia")).click();
    driver.findElement(By.id("crea-button")).click();
    assertEquals("Paziente inserito correttamente", closeAlertAndGetItsText());
  }
}
