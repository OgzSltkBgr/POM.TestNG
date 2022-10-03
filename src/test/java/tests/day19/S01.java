package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class S01 {
    @Test
    public void test01() throws InterruptedException {
        HepsiBuradaPage hepsiburadaPage = new HepsiBuradaPage();
        // https://www.hepsiburada.com/  adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Basligin "Turkiye'nin En Buyuk Alisveris Sitesi"  icerdigini dogrulayin
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("hepsiBuradaExpectedTitle")));

        Thread.sleep(1000);
        //Driver.getDriver().manage().deleteAllCookies();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.DOWN).perform();
        //Driver.getDriver().switchTo().alert().dismiss();
        // SearchBox a "araba" yazip aratin

        hepsiburadaPage.hepsiburadaSearchBox.sendKeys("araba", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        System.out.println("Sonuc yazisi: " + hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText());
        // Sonuc yazisinin "araba" icerdigini dogrulayin

        Assert.assertTrue(hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText().contains("araba"), "Sonuc yazisi 'araba' icermiyor!");
        // Sonuc yazisinin "oto" icermedigini dogrulayin
        Assert.assertFalse(hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText().contains("oto"), "Sonuc yazisi 'oto' iceriyor!");

        Driver.closeDriver();
    }
}
