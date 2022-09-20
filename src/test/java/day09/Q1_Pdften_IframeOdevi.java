package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1_Pdften_IframeOdevi {


    //  ●https://the-internet.herokuapp.com/iframe adresinegidin.
    //  ●Bir metod olusturun:iframeTest
    //  ○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
    //  yazdirin.
    //  ○Text Box’a “Merhaba Dunya!”yazin.
    //  ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.

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
    public void iframeTest() {

    }
}
