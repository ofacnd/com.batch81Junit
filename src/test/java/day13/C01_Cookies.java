package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test01() {
//      1-Amazon anasayfaya gidin
            driver.get("https://amazon.com");

//      2- tum cookie’leri listeleyin
        Set<Cookie> tumCookies = driver.manage().getCookies();
        System.out.println(tumCookies);
        int sayac = 1;
        for (Cookie w:tumCookies) {
            System.out.println(sayac + ". cookie..: " + w);
            System.out.println(sayac + ". name....: " + w.getName());
            System.out.println(sayac + ". values..: " + w.getValue());
            sayac++;

        }

//      3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesSayisi = tumCookies.size();
        Assert.assertTrue(cookiesSayisi > 5);

//      4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookies) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }

        }

//      5- ismi “ensevdigimcookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("ensevdigimcookie" ,"cikolatali" );
        driver.manage().addCookie(yeniCookie);
        tumCookies = driver.manage().getCookies();

        sayac = 1;
        for (Cookie w:tumCookies) {
            System.out.println(sayac + ". cookie..: " + w);
            System.out.println(sayac + ". name....: " + w.getName());
            System.out.println(sayac + ". values..: " + w.getValue());
            sayac++;

        }

//      6- eklediginiz cookie’nin sayfaya eklendigini test edin.
        Assert.assertTrue(tumCookies.contains(yeniCookie));

//      7- ismi skin olan cookie’yi silin ve silindigini test edin.
        driver.manage().deleteCookieNamed("skin");
        tumCookies = driver.manage().getCookies();

        sayac = 1;
        for (Cookie w:tumCookies) {
            System.out.println(sayac + ". cookie..: " + w);
            System.out.println(sayac + ". name....: " + w.getName());
            System.out.println(sayac + ". values..: " + w.getValue());
            sayac++;

        }
        Assert.assertFalse(tumCookies.contains("skin"));

//      8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookies = driver.manage().getCookies();
        Assert.assertTrue(tumCookies.isEmpty());




    }
}
