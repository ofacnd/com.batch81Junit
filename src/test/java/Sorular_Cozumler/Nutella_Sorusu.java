package Sorular_Cozumler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Nutella_Sorusu {
    /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        5 Arama cubuguna “Nutella” yazip aratin
        6 Bulunan sonuc sayisini yazdirin
        7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8 Sayfayi kapatin
         */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01() {
        // 1-C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        // 4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")) {
            System.out.println("Passed");
        } else System.out.println("failled");
        // 5 Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("Nutella", Keys.ENTER);
        // 6 Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonuc.getText());
        // 7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] sonucArray = sonuc.getText().split(" ");
        String yeni = sonucArray[1].replace(".", "");
        int istenen = 10000000;
        int sonuc1 = Integer.parseInt(yeni);
        if (sonuc1 > istenen) {
            System.out.println("passed");
        } else System.out.println("failled");




    }
}

