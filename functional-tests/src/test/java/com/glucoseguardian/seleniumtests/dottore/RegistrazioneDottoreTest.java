package com.glucoseguardian.seleniumtests.dottore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class RegistrazioneDottoreTest extends AbstractSeleniumTest {

  @Test
  public void testTC2_1() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");

    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("La lunghezza del campo nome non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_2() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys(
        "Aldiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("La lunghezza del cognome non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC2_3() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963YXYALA");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("La lunghezza del codice fiscale deve essere di 16 caratteri",
        closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_4() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Aldo");
    driver.findElement(By.id("signupCognome")).sendKeys("Bianchi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("BNCLDA72E17A535H");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("17/05/1972");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("NA1234");
    driver.findElement(By.id("signupMail")).sendKeys("dottore2@glucoseguardian.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Pozzuoli, Corso umberto 61");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("Codice fiscale già presente nel database", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_5() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
   
    assertEquals("il sesso non è valido", closeAlertAndGetItsText());
  }


  @Test
  public void testTC2_6() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06-2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("la data nascita inserita non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_7() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/3001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("La data di nascita è nel futuro", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_8() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldihotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("L'email non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_9() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("dottore@glucoseguardian.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("Email già presente nel database", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_10() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono"))
        .sendKeys("393877654222222222222222222222222222222222");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Caserta Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("il campo numero di telefono non rispetta il formato", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_11() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();
    
    assertEquals("La lunghezza dell'indirizzo non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC2_12() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("La lunghezza del campo password non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_13() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys(
        "DiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologoDiabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("la lunghezza del campo Specializzazione non è valida", closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_14() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("La lunghezza del campo Codice Albo non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC2_15() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("La lunghezza del campo Nome Struttura non è valida", closeAlertAndGetItsText());
  }


  @Test
  public void testTC2_16() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys(
        "Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52Caserta Via Roma 52");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("La lunghezza del campo Indirizzo Struttura non è valida",
        closeAlertAndGetItsText());
  }

  @Test
  public void testTC2_17() throws Exception {
    driver.get(baseUrl + "signup/signup.html");
    driver.findElement(By.id("signupNome")).sendKeys("Matteo");
    driver.findElement(By.id("signupCognome")).sendKeys("Aldi");
    driver.findElement(By.id("signupCodiceFiscale")).sendKeys("LDAMTT01H09B963Y");
    new Select(driver.findElement(By.id("signupSesso"))).selectByVisibleText("Maschio");
    driver.findElement(By.id("signupDataNascita")).sendKeys("09/06/2001");
    driver.findElement(By.id("signupSpecializzazione")).sendKeys("Diabetologo");
    driver.findElement(By.id("signupCodIscAlbo")).sendKeys("5545 San nicola la strada");
    driver.findElement(By.id("signupMail")).sendKeys("matteo.aldi@hotmail.it");
    driver.findElement(By.id("signupTelefono")).sendKeys("3938776542");
    driver.findElement(By.id("signupNomeStruttura")).sendKeys("Studio Medico  Nuova Salute");
    driver.findElement(By.id("signupIndirizzoStruttura")).sendKeys("Caserta Via Roma");
    driver.findElement(By.id("signupIndirizzo")).sendKeys("Via Vico 1");
    driver.findElement(By.id("signupPassword")).sendKeys("blabla*blabla-");
    driver.findElement(By.id("signupBtn")).click();

    assertEquals("Dottore registrato correttamente", closeAlertAndGetItsText());
  }
}
