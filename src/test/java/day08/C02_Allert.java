package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allert {
    /*
    Bir web sitesine girdigimizde karsimiza bir uyari mesaji ya da bir butona tikladigimizda bir uyari cikabilir.
    Eger bu uyariya "sag tik> inspect" yapabiliyorsak bu tur uyarilara HTML ALLERT denir ve istedigimiz locate`i yapabiliriz.

    Ama eger gelen uyari kutusuna mudahele edemiyorsak (sag tik > inspect) bu tur uyarilara JAVASCRIPT_ALERTS denir.
    JS Alert`lere mudahele icin
    -"TAMAM/OK"  icin  >   driver.switchTo().alert().accept()     kullanilmalidir.
    -"IPTAL" icin   >    driver.switchTo().alert().dismiss()      kullanilmalidir.
    -Alert Icindeki mesaji almak icin    >    driver.switchTo().alert().getText()      kullanilir
    -Alert bizden bir metin istiyorsa     >   driver.switchTo().alert().sendKeys("")   kullanilir.
     */

    /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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

    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //Bir metod olusturun: acceptAlert
        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //    “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj, actualMesaj);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        //Bir metod olusturun: dismissAlert
        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement((By.xpath("//*[text()='Click for JS Confirm']"))).click();
        Thread.sleep(3000);
        //  Alert Uzerindeki mesaji Yazdirin.
        System.out.println("2. Butonun Alert Mesaji...:" + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertFalse(actualMesaj.contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        // Bir metod olusturun: sendKeysAlert
        //    3. butona tıklayın,
        //    uyarıdaki metin kutusuna isminizi yazin,
        //    OK butonuna tıklayın
        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //Alert uzerindeki mesaji yazdiriniz.
        Thread.sleep(2000);
        System.out.println("3. Butonun Alert Mesaji..: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Omer Fatih ORUCU");
        driver.switchTo().alert().accept();
        String actualMesaj = driver.findElement(By.id("result")).getText();
        String expectedMesaj = "Omer Fatih ORUCU";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }

}
