package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_KoalaResort extends TestBaseBeforeAfter {
    @Test
    public void test01(){
        driver.get("https://www.koalaresorthotels.com");

        //2) login butonuna tikla   (3 farkli yol ile)
        driver.findElement(By.cssSelector("#navLogon")).click();
       // driver.findElement(By.xpath("//*[text()='Log in']")).click();
        //driver.findElement(By.xpath("//*[@id='navLogon']")).click();


        //3) Login ekranina girdiginizi 4 farkli web elementi kullanarak dogrulayiniz.
        //I)
        Assert.assertTrue("Login ekranina giris yapilamadi", driver.getTitle().contains("Log in"));
        //II)
        String expectedURL = "https://www.koalaresorthotels.com/Account/Logon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Login ekranina giris yapilamadi.",expectedURL, actualURL);
        //III)
       //   WebElement L3 = driver.findElement(By.xpath("(//*[@id='nav-link'])[7]"));
        //IV)
     //   Assert.assertTrue("URL yanlis", driver.getCurrentUrl().contains("Logon"));





    }
}
