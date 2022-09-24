package day13;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test() {

        // login() metodun oluşturun ve oturumaçın.
        // table( ) metoduoluşturun
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        // printRows( ) metodu oluşturun//tr



        login();
        table();
        printRows();


    }

    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody

       /*
        Tabloda <table> tag'ı altında tablonun başlığını gösteren <thead> tagı bulunur.
        Eğer başlıkta satır(row) varsa  <thead> tag'ı altında <tr>(satır-row) tagı vardır.
        Ve başlıktaki sütunlara yani hücrelere(cell) de <th> tag'ı ile ulaşılır.
        Başlığın altinda yer alan tablodaki verilere <tbody> tag'ı ile altındaki satırlara(row) <tr> tag'ı ile,
        sütunlara yani hücrelere <td> tag'ı ile ulaşırız.
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//th"));
        System.out.println("Tabloda Yer Alan Sutun Sayisi...: " + sutunSayisi.size());

    }

    private void printRows() {
        // Table’daki tum body ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar..: " + basliklar.getText());

        WebElement bodyler = driver.findElement(By.xpath("//tbody"));
        System.out.println("Bodyler...: " + bodyler.getText());

        // table body’sinde bulunan toplam satir(row) sayısınıbulun.
        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satir Sayisi...: " + rows.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        rows.forEach(t -> System.out.println(t.getText()));

        // 4.satirdaki(row) elementleri konsoldayazdırın.
        WebElement rowElementleri = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(rowElementleri.getText());
    }

    private void login() {
        // Username :manager
        // Password :Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
