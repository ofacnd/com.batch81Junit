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

public class Dogru_Email {
    /*
    Tarayıcıyı başlatın
9. 'Çıkış' düğmesini tıklayın
10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
       // 2. 'http://automationexercise.com' url'sine gidin

    }

    @AfterClass
    public static void tearDown() {
        // driver.close();
    }

    @Test
    public void test1() {
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     String expectedURL = "automationexercise.com";
     String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }
    @Test
    public void test2() throws InterruptedException {
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test3() {
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement((By.xpath("//*[text()='Login to your account']"))).isDisplayed());
    }
    @Test
    public void test4() {
        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.name("email")).sendKeys("oforucu@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1iki3dort5alti");
    }
    @Test
    public void test5() {
        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
    }
    @Test
    //8. kullniici girisinin yapildigini dogrula
    public void test6() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
    }

    @Test
    public void test7() {

    }

}
