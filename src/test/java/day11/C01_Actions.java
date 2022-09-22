package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        actions = new Actions(driver);
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramakutusu).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                //A  harfini buyuk yazmak icin shift`e basili tutup a ya bastik.Ardindan SHIFT`ten elimizi kaldirdik.
                sendKeys("71").sendKeys(Keys.ENTER).// Sayilari da girip ENTER`a bastik.
                perform();
        //aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());


    }
}
