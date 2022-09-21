package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
@Test
    public void test() throws InterruptedException {
    //2-  'https://the-internet.herokuapp.com/context_menu' sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");

    //3-  Cizili alan uzerinde sag clickyapalim
    WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
    Actions hareketler = new Actions(driver);
    hareketler.contextClick(cizgiliAlan).perform();
    Thread.sleep(3000);

    //4-  Alert’te cikan yazinin “You selected a context menu”oldugunu testedelim
    Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());


    //5-  "Tamam"    diyerek alert’ikapatalim
    Thread.sleep(2000);
    driver.switchTo().alert().accept();



    //6-  Elemental Selenium linkine tiklayalim
    driver.findElement(By.xpath("//*[@target='_blank']")).click();
    List<String> windowList = new ArrayList<>(driver.getWindowHandles());
    //2 pencere acildi, her pencereyi list ile handle ediyoruz.
    //  2. TAB`a ulasmak icin list uzerinden index numarasi ile 2. pencereye ulasmak icin  windowList.get(1)  kullaniyoruz.
    driver.switchTo().window(windowList.get(1));   // Burada da 2. pencereye gidiyoruz.

    //7-  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini testedelim
    Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());



}
}
