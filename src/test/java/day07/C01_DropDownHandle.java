package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDownHandle {
    /*
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/
     WebDriver driver;

    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://amazon.com");

    }

    @After
    public  void tearDown() {
        // driver.close();
    }
    @Test
    public void test01(){
       // -Test1
       // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
       // oldugunu testedin
        List<WebElement> dropMenu = driver.findElements(By.xpath("//option"));
        System.out.println(dropMenu.size());
        for (WebElement drop : dropMenu) {
            System.out.println(drop.getText());
        }
        int dropDownList = dropMenu.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi,dropDownList);

            
        }


    @Test
    public void test02(){
     //  -Test2
      // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
      // 2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
      // 3.Bulunan sonuc sayisiniyazdirin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Java Arama SOnucu...: " + sonuc.getText());
      // 4.Sonucun Java kelimesini icerdigini testedin
        String beklenenKelime = "Java";
        String actualKelime = sonuc.getText();
        Assert.assertTrue(actualKelime.contains(beklenenKelime));


    }
}
