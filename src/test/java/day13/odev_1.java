package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class odev_1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // Bir Class olusturun D19_WebtablesHomework
        // "https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // Headers da bulunan department isimlerini yazdirin
        List<WebElement> depertmantList = driver.findElements(By.xpath("//*[@class='rt-td'][6]"));
        for (WebElement w : depertmantList) {
            System.out.println(w.getText());
        }
        // sutunun basligini yazdirin
        System.out.println("Sutun Baslıgı : " + driver.findElement(By.xpath("(//*[@class='rt-resizable-header-content'])[6]")).getText());
        // Tablodaki tum datalari yazdirin
        List<WebElement> tumData = driver.findElements(By.xpath("//*[@class='rt-tr-group']"));
        for (WebElement w : tumData) {
            System.out.println(w.getText());
        }
        // Tabloda kac cell (data) oldugunu yazdirin
        // Tablodaki satir sayisini yazdirin
        System.out.println("Satir Sayisi : " + tumData.size());
        // Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//*[@class='rt-resizable-header-content']"));
        System.out.println("Sutun Sayisi : " + sutunSayisi.size());
        // Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("//*[@class='rt-td'][3]"));
        System.out.println("3.Kolon");
        for (WebElement w : ucuncuKolon) {
            System.out.println(w.getText());
        }
        // Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //System.out.println("Kierra Salary : " + driver.findElement(By.xpath("//*[text()='2000']")).getText());
        int sayac = 1;

        List<WebElement> firstName=driver.findElements(By.xpath("//div[@class='rt-td'][1]"));
        for (WebElement w : firstName){
            System.out.println(w.getText());
        }
        for (WebElement each:firstName) {
          if (each.getText().equals("Cierra")){
              System.out.println(driver.findElement(By.
                      xpath("//*[@class='rt-tr-group'][" + sayac + "]//*[@class='rt-td'][5]")).getText());
         }
          sayac++;

      }



        // Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
        printData(3, 6);
    }

    public void printData(int row, int column) {
        System.out.println(row + ".satir " + column + ".sutun : " + driver.
                findElement(By.xpath("//*[@class='rt-tr-group'][" + row + "]//*[@class='rt-td'][" + column + "]")).getText());
    }
}