package tests.day21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_AE25 {
    AutomationExercisePage automationExercisePage;
    @Test
    public void test01() {
        automationExercisePage = new AutomationExercisePage();
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aoutoExerciseUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(automationExercisePage.autoHomeButton.isDisplayed());

        //4. Scroll down page to bottom
        ReusableMethods.jsExecutorScrool(automationExercisePage.subscriptonElement);

        //5. Verify 'SUBSCRIPTION' is visible,
        Assert.assertTrue(automationExercisePage.subscriptonElement.isDisplayed());

        //6. Click on arrow at bottom right side to move upward
        automationExercisePage.yukariCikOku.click();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        Assert.assertTrue(automationExercisePage.fullFledgedElement.isDisplayed());

        Driver.closeDriver();
    }
}
