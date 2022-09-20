package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
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
    public void iframeTest() throws InterruptedException {

        //●https://the-internet.herokuapp.com/iframe adresinegidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

        //○Text Box’a “Merhaba Dunya!”yazin.
        WebElement textbox = driver.findElement(By.id("mce_0_ifr"));  //Frame`e gecis yapmadan once Bu kismi locate edelim.
        driver.switchTo().frame(textbox);  //  Locate edilen frame`e gecmek icin SWITCHTO methodunu kullaniriz.
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        // Frame`e gecis yaptik evet AMA; textbox icin ayrica bir daha location yapmamiz gerekiyor. Ustteki satir textbox`i locate ettigimiz yer.
        Thread.sleep(2000);
        textBoxFrame.clear();  // Bu method Frame`deki TextBox`in icini temizler.
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");   //Locate edilmis olan frame`deki locate edilmis olan textbox`a yaziyi gonderdik.
        //○TextBox’in altinda bulunan “Elemental Selenium” linkinin,
        // textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        /*
        daha once textBox`a ulasmak icin icice frame`ler ayrica location yapmistik.
        En alt katmanda textbox`a yazi yazdirdik ama locater orada kaldi.
        Locater `i en ust katmana yani tekrar siteye geri getirmek icin 53. satirda yer alan kodu kullaniriz.
        Boylece artik tekrar ana site katmanina erismis oluruz ve istedigimiz diger islemleri halledebiliriz.
        Ic ice frameler arasinda gezinebilmek, diger frame`lere ulasmak icin locater ile giris yapmamiz gerektigi gibi
        cikis da yapmak yani web asayfasinin en ust katmanina ulasmak zorundayiz.
        velhasili; 53. satir: locater`dan geri gelmek icin kullanilir.
         */
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());
    }
}