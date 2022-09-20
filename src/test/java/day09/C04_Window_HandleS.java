package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Window_HandleS {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
       //driver.close();
       //driver.quit();
    }

    @Test
    public void WindowHandle() {

        // 1) https://the-internet.herokuapp.com/windows adresinegidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String intHandle = driver.getWindowHandle();

         // 2) Sayfadaki textin “Opening a new window” olduğunudoğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        // 3) Sayfa başlığının(title) “The Internet” olduğunudoğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

         // 4) Click Here butonunabasın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Degerleri..: " + windowList);
        driver.switchTo().window(windowList.get(1));

         // 5) Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunudogrulayin.
        Assert.assertTrue(driver.getTitle().contains("New Window"));

         // 6) Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.getPageSource().contains("New Window"));

         // 7) Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(intHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));



    }
}
