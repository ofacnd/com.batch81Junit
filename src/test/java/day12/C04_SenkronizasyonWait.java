package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void test() {
        //1.Bir class olusturun :EnableTest
        //2.Bir metod olusturun :isEnabled()
        //3.https://the-internet.herokuapp.com/dynamic_controls adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.Textbox’in etkin OLMADIGINI (enabled) dogrulayın
        WebElement textBox  =  driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //5.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6.“It’s enabled!” mesajinin goruntulendiginidogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());

        //7.Textbox’in etkin oldugunu(enabled)dogrulayın.
        Assert.assertTrue(textBox.isEnabled());


    }
}
