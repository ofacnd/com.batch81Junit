package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test(){
        //Automationexercises.com adresine gidelim
        driver.get("https://www.automationexercise.com");

        //Product bolumune girelim.
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        //Ilk urune tiklayalim.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();

    }
}
