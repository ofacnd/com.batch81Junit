package day15;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon Sayfasina git, Tum sayfanin resmini al.

        driver.get("https://www.bestbuy.ca");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaSS = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaSS, new File("target/ekranGoruntusu/allPage_"+tarih+"_.jpeg"));

         /*
        Bir web sayfasinin SS`ini alabilmek icin   TakesScreenshot  class`indan bir obje olusturup
        gecici bir file class`indan degiskene TakesScreenshot`dan olusturdugum obje`den
        getScreenshotAs methodu sayesinde gecici bir file olustururuz.
         */

        //resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
        //tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip uygun hale getirdik.
        //sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik.

    }
}
