package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExist extends TestBaseBeforeAfter {
    @Test
    public void FileExist() throws InterruptedException {

     //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
     //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='sample.text']")).click();
        Thread.sleep(2000);
     //4- Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Tumay Fatih\\Downloads\\sample.text";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //5- indirildigini konsolda gosteriniz.
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}
