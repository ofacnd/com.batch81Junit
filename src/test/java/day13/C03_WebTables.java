package day13;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import java.util.List;
public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir önceki class'daki adrese gidelim
        // Login () methodunu kullanarak sayfaya giris yapalım
        login();
        int satir=4;//bunların kesişimi size vermesi gerekir
        int sutun=4;
        //input olarak verilen satir sayisi ve sutun sayisina sahip cell deki texti yazdıralım
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(("satir ve sutundaki text: " +cell.getText()));
        //Price basligindaki tum numaraları yazdırınız
        List<WebElement> price=driver.findElements(By.xpath("//tbody//tr[*]//td[6]"));
        for (WebElement w:price
        ) {
            System.out.println(w.getText());
        }
    }
    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}