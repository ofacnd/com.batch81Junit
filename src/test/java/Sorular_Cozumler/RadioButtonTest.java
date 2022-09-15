package Sorular_Cozumler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static Sorular_Cozumler.Q01.C01_HomeworkWithBeforeClassAfterClass.driver;

public class RadioButtonTest {
    WebDriver driver;
    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {

   //     - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
   //     - Cookies’i kabul edin
   //     - “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //     - “radio buttons” elementlerini locate edin
        driver.findElement(By.name("firstname")).sendKeys("Omer Fatih");
        driver.findElement(By.name("lastname")).sendKeys("Orucu");





   //     - Secili degilse cinsiyet butonundan size uygun olani secin


    }


    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
