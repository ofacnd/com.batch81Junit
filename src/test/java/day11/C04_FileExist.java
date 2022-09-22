package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist  {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
           //Su an dosyanin icinde bulundugu yerin yolunu gosterir.
        System.out.println(System.getProperty("user.home"));
           // gecerli kullanicinin ana dizinini verir.
/*
        String farkliBolum = System.getProperty("user.home");
           // "C:\Users\Tumay Fatih\Desktop\text.txt"  masaustunde yer alan dosyanin yolu.
        String ortakBolum = "\\Desktop\\text.txt";

        String masaustuDosyaYolu  = farkliBolum + ortakBolum;
        System.out.println(Files.exists(Path.of(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaustuDosyaYolu)));  //  >> ONEMLI OLAN YER
*/
//  BILMEMIZ GEREKEN KISIM:
        String dosyaYolu = "C:\\Users\\Tumay Fatih\\Desktop\\text.txt";
        //System.out.println(Files.exists(Path.of(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdigimiz ya da windows icinde olusturdugumuz dosyanin
        indigini ya da orada oldugunu test edebilmem icin o dosyanin uzerine shift+sag tik yapip,
        dosyanin yolunu kopyalariz. Bu veriyi bir STRING degiskene atariz.

        Dosyayi dogrulamak icin            Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));    Methodunu kullaniriz.
         */
    }
}
