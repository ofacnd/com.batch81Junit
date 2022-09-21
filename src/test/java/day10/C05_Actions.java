package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {
@Test
    public void test() throws InterruptedException {

         // https://demoqa.com/droppable adresine gidelim
    driver.get("https://demoqa.com/droppable");

         // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
    WebElement dropMe = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
    //Actions actions = new Actions(driver);
    Thread.sleep(2000);
    actions.dragAndDrop(dragMe, dropMe).perform();  // extends class`tan actions`i cekti... Basarili!
    Thread.sleep(2000);

         // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

}

}
