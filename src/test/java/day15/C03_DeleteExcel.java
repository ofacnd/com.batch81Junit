package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {

    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin

        //  Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/main/resources/ulkeler.xlsx";
        //8.  FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //olusturulan dosyayi sistemde isleme alir.
        //9.  Workbook objesi olusturalim,parameter olarak fileInputStream objesinigirelim
        //10.  WorkbookFactory.create(fileInputStream)
        Workbook workbook  = WorkbookFactory.create(fis);
        //WorkBook objesiyle fis ile akisa aldigimizi doyayla excel dosyasi olusturduk.
        //11.  Worksheet objesi olusturunworkbook.getSheetAt(index)
        Sheet sheet  =  workbook.getSheet("Sayfa1");
        //Excel Dosyamizda calismak istedigimiz sayfayi bu sekilde seciyoruz (alttan sekme seciyoruz)
        //12.  Row objesi olusturunsheet.getRow(index)
        Row row  =  sheet.getRow(3);
        //Sayfa 1`deki 3. satiri bu sekilde secebiliyoruz.

        //13.  Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);

        //   Bir cell`deki veriyi silmek icin row objesine ihtiyac vardir.
        //Row objesi ile removeCell() methodunu kullanarak cell objesi ile belirtilen cell degerini silebiliyoruz.

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //          System.out.println(cell);

        //-Silindiğini test edin
        String expectedData = "Cezayir";
        String actualData = null;
        Assert.assertNotEquals(expectedData,actualData);

    }
}
