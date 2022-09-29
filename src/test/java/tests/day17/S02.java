package tests.day17;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class S02 {
    @Test
    public void test01() {
        // facebook sayfasına gidin
        Driver.getDriver().get("https://facebook.com");

        // cokies kabul edin
        FacebookPage facebookPage=new FacebookPage();
        //facebookPage.facebookCookies.click();

        // kullanıcı mail kutusuna rastgele bir isim yazdırın
        Faker faker = new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());

        // kullanıcı sifre kutusuna rastgele bir password yazdırın
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        // login butonuna basin
        facebookPage.loginButonu.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYazisiElementi.isDisplayed());

        Driver.closeDriver();
    }
}
