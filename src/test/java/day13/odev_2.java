package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;

public class odev_2 extends TestBaseBeforeAfter {

    //Bir metod oluşturun : printData(int row, int column);
    //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    //Baska bir Test metodu oluşturun: printDataTest( );
    //Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
    //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    @Test
    public void odev_2() throws InterruptedException {
        //http://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //Username : manager
        //Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@class='btn btn-success uppercase']")).click();

        int row = 3;
        int column = 5;

        Object expectedData = "USA";
        Object data = printData(row, column);
        System.out.println(data);

        Assert.assertEquals(expectedData, data);



    }
    private Object printData(int row, int column) {
        WebElement dataWE  =   driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        Object data = dataWE.getText();


    return data;
    }


}
