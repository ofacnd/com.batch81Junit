package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q01_Odev_guru99 {
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


        //1)http://demo.guru99.com/test/guru99home/sitesinegidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2)sayfadaki iframe sayısınıbulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi.size());

        //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@height='315']")));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();


        //4)ilk iframe'den çıkıp ana sayfaya dönünüz.
            driver.switchTo().defaultContent();

        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }



    }
