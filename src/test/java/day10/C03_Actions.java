package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //- Amazon`a gidelim
        //- Account Menusunden create a list linkine tiklayalim.
        driver.get("https://www.amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde, mouse hareketi ile acilan bir webelement`ine ulasmak istersek
        actions.moveToElement()     methodunu kullanmamiz gerekir.
        Aksi halde html kodlari arasinda web elementi bulur ama ulasamadigi icin
        ElementNotInteractableException      exception`i verebilir.
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}
