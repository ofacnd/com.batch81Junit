package Sorular_Cozumler;

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

public class YanlisEmail {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php");
        // 2.http://automationpractice.com/index.php sayfasinagidelim

    }

    @AfterClass
    public static void tearDown() {
        // driver.close();
    }

    @Test
    public void test1() {
        // 3.Sign in butonunabasalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

    }

    @Test
    public void test2() {
// 4.Email kutusuna @isareti olmayan bir mail yazipenter'a
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("denemegmail.com");

    }

    @Test
    public void test3() {
// bastigimizda "Invalid email address" uyarisi ciktigini testedelim
        driver.findElement(By.id("SubmitCreate")).click();
        WebElement invalidUyari = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalidUyari.isDisplayed());
    }


}
