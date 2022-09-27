package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel  {

    @Test
    public void readExcelTest() throws IOException {
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
        System.out.println(cell);
                          //Satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir.



        //3. index`teki satirin 3. index`indeki datanin "Cezayir" oldugunu test edin.
        String expectedData  =  "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());
    }
}
