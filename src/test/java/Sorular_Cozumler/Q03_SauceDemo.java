package Sorular_Cozumler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Q03_SauceDemo {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //        2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //        3. Password kutusuna “secret_sauce” yazdirin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //        4. Login tusuna basin
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.className("inventory_item_name"));
        System.out.println("urun adi : " + ilkUrun.getText());
        ilkUrun.click();
        //driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        Thread.sleep(1000);
        // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet=driver.findElement(By.className("inventory_item_name"));
        if (sepet.isDisplayed()){
            System.out.println("Urun Testi PASSED");
        } else {
            System.out.println("Urun Testi FAILED");
        }
    }
    // 9 Sayfayi kapatin
    @After
    public void tearDown() {
        driver.close();
    }
}












