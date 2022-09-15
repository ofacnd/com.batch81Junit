package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions_YouTube {
    /*
        1) Bir class oluşturun: YoutubeAssertions
        2) https://www.youtube.com adresine gidin
        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

        ○ titleTest
        => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest
        => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
          */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown() {
        // driver.close();
    }
    @Test
    public void test1() {
        //        => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    @Test
    public void test2() {
        //        => YouTube resminin görüntülendiğini (isDisplayed()) test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-yoodle-renderer'])[1]")).isDisplayed());

    }
    @Test
    public void test3() {
        //        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
Assert.assertTrue(driver.findElement(By.xpath("//*[@autocapitalize='none']")).isEnabled());
    }
    @Test
    public void test4() {
//        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "youtube";
        String actualTitle2 = driver.getTitle();
        Assert.assertFalse(actualTitle2.equals(unexpectedTitle));
    }
}
