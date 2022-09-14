package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class C1_Maven_ilk_test {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));


        // 3- “Samsung headphones” ile arama yapalim
        Thread.sleep(2000);
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        // 4- Bulunan sonuc sayisini yazdiralim

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());

        //String [] sonucYazisi = driver.findElement
        //        (By.xpath("(//*[@class='a-section a-spacing a-spacing-top-small'])[1]")).getText().split(" ");
        //System.out.println("Samsung HeadPhones Icin Arama Sonucu...: " + sonucYazisi[3]);

        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // 6- Sayfadaki tum basliklari yazdiralim

        List<WebElement> basliklar = driver.findElements(By.xpath("//h2"));
        for (WebElement each : basliklar) {
            System.out.println(each.getText());


        }
    }
}

