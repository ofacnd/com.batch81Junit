package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class AmazonTeamWork extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //go to Amazon
        driver.get("https://www.amazon.com");
        //Move to Hello Sign
        Actions actions = new Actions(driver);
        WebElement helloSign=driver.findElement(By.xpath("//*[@class='nav-line-1 nav-progressive-content']"));
        actions.moveToElement(helloSign).perform();


        //find the music Library and click
    }
}
