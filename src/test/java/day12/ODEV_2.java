package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class ODEV_2 extends TestBaseBeforeAfter {
    @Test
    public void ocev_2(){
        //1.“http://webdriveruniversity.com/IFrame/index.html”sayfasinagidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");


        //2.“Our Products” butonunabasin
        WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement frameCheck = driver.findElement(By.id("frame"));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameCheck));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Our Products']"))).click();


        //3.“Cameras product”itiklayin
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='section-title'])[2]"))).click();

        //4.Popup mesajiniyazdirin
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-header']"))));

        //5.“close” butonunabasin
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]")).click();

        //6."WebdriverUniversity.com (IFrame)" linkinitiklayin
        driver.switchTo().defaultContent();
        driver. findElement(By.xpath("//*[@id='nav-title']")).click();

        //7."http://webdriveruniversity.com/index.html" adresine gittigini testedin
        Assert.assertEquals(driver.getCurrentUrl(),"http://webdriveruniversity.com/index.html");
    }
}
