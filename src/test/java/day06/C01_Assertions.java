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

public class C01_Assertions {
    /*
    -Amazon sayfasina git.
    -3 farkli test methodu olustur.
        a- URL`nin amazon icerdigini test et.
        b- title`in facebook icermedigini test et.
        c- Sol ust kosede amazon logosunun gorundugunu test edelim.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.com");
        // Not : Before & After methodunda testleri farklı sayfalarda açıp kapatıyor,
        // Beforeclass & AfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.

        // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //a- URL`nin amazon icerdigini test et.
        String expectedUrl = "amazon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedUrl));

    }

    @Test
    public void test02() {
        // b- title`in facebook icermedigini test et.
        String actualTitle = driver.getTitle();
        String unExpectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(unExpectedTitle));


    }

    @Test
    public void test03() {
//        c- Sol ust kosede amazon logosunun gorundugunu test edelim.
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test4() {
        //d- URL`leri karsilastiralim.
        String expectedUrl = "https://www.facebook.com";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("URL`ler esit degil  !!", expectedUrl, actualURL);
    }





}
