package tests.day20;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AmazonTest {
    AmazonPage amazonPage=new AmazonPage();
    @Test
    public void testName() throws InterruptedException, IOException {
        String date;
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String path="src/TestExcel.xlsx";
        String page="Sheet1";
        Workbook workbook=null;
        String aranacak;
        String sonucYazisi;
        WebElement sonucElementi;
        File gecici;
        File dosyaYolu;
        int satirSayisi=workbook.getSheet("Sheet1").getLastRowNum();
        FileOutputStream fos;
        try {
            FileInputStream fis=new FileInputStream(path);
            workbook= WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i =1; i <=satirSayisi ; i++) {
            aranacak=workbook.getSheet(page).getRow(i).getCell(0).toString();
            amazonPage.amazonSearchBox.sendKeys(aranacak, Keys.ENTER);
            Thread.sleep(3000);
            sonucYazisi=amazonPage.sonucYazisiElementi.getText();
            sonucElementi=amazonPage.sonucYazisiElementi;
            date=new SimpleDateFormat("yymmddhhmmss").format(new Date());
            dosyaYolu=new File("target/SS/Excell"+date+".jpeg");
            gecici=sonucElementi.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(gecici,dosyaYolu);
            workbook.getSheet(page).getRow(i).createCell(1).setCellValue(sonucYazisi);
            workbook.getSheet(page).getRow(i).createCell(2).setCellValue(""+gecici);
            amazonPage.amazonSearchBox.clear();
            fos=new FileOutputStream(dosyaYolu);
            workbook.write(fos);
        }
    }
}
