package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
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
    public void test01(){
        //Yotube videosunu calistiriniz.
        driver.get("https://html.com/tags/iframe/");
        List<WebElement> iframList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        //Bu satirda sitede yer alan iframe`leri bir liste attik.
        // Simdi sirada bu list`de yer alan iframe`lerden hangisini oynatmak istedigimizi secmeye geldi.
        //   Tum iframe`leri bir list`e almamiziin temel nedeni: sitede yer alan 65 iframe icinden istedigimizi belirleyebilmekten ziyade,
        //   Bu iframe`lerin linklerinin daha sonra degisme ihtimaline karsi iframe sirasina gore dizip numaraya gore arama yapmanin daha garanti olmasi.
        driver.switchTo().frame(iframList.get(0));  //Bu sekilde 1. frame secmis olduk (Index 0`dan baslar).
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();


    }
}
