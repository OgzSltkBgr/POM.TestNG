package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReusableMethods {
    public static Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex){
        Cell cell=null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(fis);
            cell=workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    public static Map<String,String> mapOlustur(String path, String sayfaAdi){
        Map<String,String> excelMap=new HashMap<>();

        // ilk adim excel e ulasmak
        Workbook workbook=null;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook=WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();
        String key="";
        String value="";

        for (int i = 0; i <=satirSayisi ; i++) {
            // ikinci adim tablodaki hucreleri map e uygun hala donusturmek
            // ikinci adim tablodaki hucreleri map'a uygun hale donusturmek
            key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
          // value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString()+
          //         ", "+workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString()+
          //         ", "+workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();
            // ucuncu adim key-value haline getirdigimiz satirlari map'a eklemek
            excelMap.put(key,value);
        }

        return excelMap;
    }

}
