package tests.day17;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class S01 {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella", Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Driver.closeDriver();
    }
}
