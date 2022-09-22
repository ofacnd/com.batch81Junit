package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class ODEV_1 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //   2- Hover over Me First" kutusunun ustune gelin
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"))).perform();
        Thread.sleep(2000);
        //   3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        //   4- Popup mesajini yazdirin
        System.out.println("Pop-up Mesaji ....> " + driver.switchTo().alert().getText());
        //   5- Popup'i tamam diyerek kapatin
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
        //   6- "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id='click-box']"))).perform();
        //   7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click And Hold Box`ta Yazan Yazi....> " + driver.findElement(By.xpath("//*[@id='click-box']")).getText());
        //   8- "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me!']"))).perform();
    }
}
