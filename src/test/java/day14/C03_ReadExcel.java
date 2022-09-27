package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        // belirtilen satir no ve sutun no degerlerini parametre olarak alip
        // o cell'deki datayi konsola yazdirin
        // sonra sonucun konsolda yazanla ayni oldugunu dogrulayin.

        int satir = 12;
        int sutun = 2;

       String dosyaYolu = "src/main/resources/ulkeler.xlsx";
       FileInputStream fis = new FileInputStream(dosyaYolu); //Olusturmuş olduğumuz dosyayı sistemde işleme alır
       Workbook workbook = WorkbookFactory.create(fis);  //BUrada excel`i olusturuyoruz.
       String actualData = workbook.
               getSheet("Sayfa1").
               getRow(satir-1).
               //Yukarida tanimlanan 12  index 0dan basladigi icin 13. cell`e gidecek o yuzden -1 diyerek 12. cell`e ulasmasini sagliyoruz.
               getCell(sutun-1) //  Ayni sey burada da gecerli.
               .toString();


        System.out.println(actualData);
        String konsoldaYazan = "Baku";
        Assert.assertEquals(konsoldaYazan,actualData);



    }
}
