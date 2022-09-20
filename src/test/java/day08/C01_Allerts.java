package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
       /*
       - https://the-internet.herokuapp.com/javascript_alerts adresine git.
       - CLick for js Alert butonuna tiklayalim.
       - Tikladiktan sonra cikan uyari mesajinda (alerte`de) "tamam" butonuna basalim.
        */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void test01() throws InterruptedException {
        //       - CLick for js Alert butonuna tiklayalim.
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']\n")).click();
        //       - Tikladiktan sonra cikan uyari mesajinda (alerte`de) "tamam" butonuna basalim.
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

}
