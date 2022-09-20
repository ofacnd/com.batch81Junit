package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
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
        // driver.close();
    }

    @Test
    public void WindowHandle() {
           //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        /*
        Eger bize verilen task`te sayfalar arasi gecis olacaksa, her driver.get() methodundan SONRA  !!
        driver`in window handle degerini STRING bir degiskene atariz.
        Sonrasinda farkli bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya donmemiz istenirse
        String degiskene atadagimiz window handle degerleri ile sayfalar arasi gecis yapabiliriz.
         */

            //2- Url'nin amazon içerdiğini test edelim
        String expectedURL = "amazon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
        driver.getWindowHandle();

            //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)

        driver.switchTo().newWindow(WindowType.WINDOW);  // Yeni bir pencere acmak icin kullanilir.
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();

            //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

           //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);  //  Sayfalar arasi gecis yapmak icin bu method kullanilir.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

           //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

           //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

           //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());


           //9- Sayfaları Kapatalım

    }
}
