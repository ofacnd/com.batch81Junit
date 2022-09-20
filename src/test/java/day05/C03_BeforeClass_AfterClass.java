package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {
    //BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagimiz method`u static yapmamiz gerekiyor.
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

            @After
            //After notasyonu her testten sonra çalışır
            public void tearDown2() throws InterruptedException {
                Thread.sleep(2000);
            }
    @Test
    public void method1() {
        driver.get("https://amazon.com");
    }

              @Test
              @Ignore("buraya aciklama yazilabiliyor.")  //Calismasini istemedigimiz test`e bu sekilde ilave ederek testi iptal edebiliriz.
              public void method2() {
                  driver.get("https://techproeducation.com");
              }
    @Test
    public void method3() {
        driver.get("https://hepsiburada.com");
    }
}
