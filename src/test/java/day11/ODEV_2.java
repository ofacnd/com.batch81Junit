package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class ODEV_2 extends TestBaseBeforeAfter {
    @Test
    public void odev2() throws InterruptedException {
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        // WebElement video = driver.findElement(By.xpath("//*[@class='ytp-cued-thumbnail-overlay-image']"));
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement video = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(video);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        //videoyu calistirdiginizi test edin
      //  driver.switchTo().defaultContent();
      //  Thread.sleep(1000);
      //  actions.moveToElement(driver.findElement(By.xpath("//*[@class='video-stream html5-main-video']"))).perform();
      //  Thread.sleep(1500);
//
      //  Assert.assertFalse(driver.findElement(By.xpath("//*[@title='Pause (k)']")).isDisplayed());
    }
}
