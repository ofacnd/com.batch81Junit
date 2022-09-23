package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;
import java.time.Instant;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void implicitWaitTest() {
        //3.https://the-internet.herokuapp.com/dynamic_controls adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Remove butonunabasin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //5.“It’s gone!” mesajinin goruntulendiginidogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        //  It`s Gone!   da tek tirnak bulundugu icin hata verirdir bunu engellemek icin xpath icinde
        //    ''   tek tirnak yerine       \"  \"      arasina xpath`imizi yazariz.

        //6.Add buttonunabasin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7.It’s back mesajinin gorundugunu testedin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitWaitTest() {

        /*
                implicitlyWait kullandığımız bu method'da, max belirttiğimiz süre altında, bütün web elementler için bekler.
        */
        //3.https://the-internet.herokuapp.com/dynamic_controls adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Remove butonunabasin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //5.“It’s gone!” mesajinin goruntulendiginidogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement itsGoneWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exception fırlatır.
        Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

        //6.Add buttonunabasin
        driver.findElement(By.xpath("//*[text()='Add']")).click();


        //7.It’s back mesajinin gorundugunu testedin
        WebElement itsBackWE  =  wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());


    }
}
