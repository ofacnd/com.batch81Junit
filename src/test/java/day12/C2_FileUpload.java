package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C2_FileUpload extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //2.https://the-internet.herokuapp.com/upload adresinegidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);

        //3.chooseFile butonunabasalim
        WebElement dosyaSec  =  driver.findElement(By.xpath("//*[@id='file-upload']"));
        //aslinda burada butona basmak gerekiyor ama basmayinca direk locate edip
        // asagida 4. maddede dosya yolunu verip direk siteye yukledik.


        //4.Yuklemek istediginiz dosyayisecelim.
        String dosyaYolu  =  "C:\\Users\\Tumay Fatih\\Desktop\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);

        //5.Upload butonunabasalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();


        //6.“File Uploaded!” textinin goruntulendigini testedelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
