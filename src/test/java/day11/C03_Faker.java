package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {


    @Test
    public void FakerTest() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        
        //“firstName” giris kutusuna bir isim yazin
        Faker fakerSalla = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String emailBilgisi = fakerSalla.internet().emailAddress();
       /*
Faker class'ını kullanma amacımız form doldurmamız gereken web sitelerinde
defalarca kendi üreteceğimiz veriler yerine , bizim için random veriler üretir ve işimizi kolaylaştırır.

Faker class'ını kullanmak için mvnrespository.com adresinden java faker kütüphanesini aratır ve en çok kullanılanı
pom.xml dosyamıza (dependencies tagları arasına) ekleriz. Sonra faker class'ından bir obje oluşturup;

email için:
faker.internet() methodunu kullanarak emailAddress() method'unu seçeriz.
password: faker.internet().password()        isim: faker.name().firstName()           soyisim: faker.name().lastName()

method'larını kullanırız.
 */
        actions.click(isim).sendKeys(fakerSalla.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(fakerSalla.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(emailBilgisi).
                sendKeys(Keys.TAB).
                sendKeys(emailBilgisi).
                sendKeys(Keys.TAB).
                sendKeys(fakerSalla.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("11").sendKeys(Keys.TAB).sendKeys("22").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).perform();

        //Sayfayi kapatin
        driver.quit();
    }
}
