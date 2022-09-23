package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class ODEV_1 extends TestBaseBeforeAfter {
    @Test
    public void odev1() throws InterruptedException {
        //1."http://webdriveruniversity.com/Actions"sayfasinagidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2."Hover over Me First" kutusunun ustunegelin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown hover']")));

        //3."Link 1" e   tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //4.Popup mesajiniyazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5.Popup'i tamam diyerekkapatin
        driver.switchTo().alert().accept();

        //6."Click and hold" kutusuna basilitutun
        WebElement clickAndHold  =  driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        //7."Click and hold" kutusunda cikan yaziyiyazdirin
        System.out.println("Click And Hold Butonundaki Yazi..: " + clickAndHold.getText());


        //8."Double click me" butonunu cifttiklayin
        driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
    }
}
