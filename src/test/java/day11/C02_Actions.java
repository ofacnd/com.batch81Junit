package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

              WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
              isim.sendKeys("Erol");
              actions.sendKeys(Keys.TAB).
               sendKeys("evren").
               sendKeys(Keys.TAB).
               sendKeys("emailim@email.com").
               sendKeys(Keys.TAB).
               sendKeys("emailim@email.com").
               sendKeys(Keys.TAB).
               sendKeys("password123456").
               sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).
               sendKeys("11").sendKeys(Keys.TAB).sendKeys("22").
               sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.RIGHT).perform();
    }
}
        // 4- Kaydol tusuna basalim

