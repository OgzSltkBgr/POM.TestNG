package tests.day21;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AE24 {
    AutomationExercisePage automationExercisePage;
    @Test
    public void test01() {
        automationExercisePage = new AutomationExercisePage();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        String email=faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String adress = faker.address().toString();
        String adress2 = faker.address().secondaryAddress().toString();
        String mobileNumber= faker.phoneNumber().cellPhone();


        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aoutoExerciseUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(automationExercisePage.autoHomeButton.isDisplayed());

        //4. Add products to cart
        automationExercisePage.menTshirt.click();

        //5. Click 'Cart' button
        automationExercisePage.viewChart.click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(automationExercisePage.verifyChart.isDisplayed());

        //7. Click Proceed To Checkout
        automationExercisePage.proceedToCheckout.click();

        //8. Click 'Register / Login' button
        automationExercisePage.registerLogin.click();

        //9. Fill all details in Signup and create account
        automationExercisePage.signUpNameBox.click();
        actions.sendKeys(firstName+" "+lastName,Keys.TAB)
                .sendKeys(email,Keys.ENTER).perform();

        automationExercisePage.genderButton.click();
        automationExercisePage.createAccountPasswordBox.click();
        actions.sendKeys(password, Keys.TAB)
                .sendKeys("10", Keys.TAB).sendKeys("10", Keys.TAB).sendKeys("2010", Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(firstName,Keys.TAB)
                        .sendKeys(lastName,Keys.TAB)
                        .sendKeys("Amazon A.S.",Keys.TAB)
                        .sendKeys(adress,Keys.TAB)
                        .sendKeys(adress2,Keys.TAB)
                        .sendKeys("United States",Keys.TAB)
                        .sendKeys("Chicago",Keys.TAB)
                        .sendKeys("Chicago",Keys.TAB)
                        .sendKeys("15215",Keys.TAB)
                        .sendKeys(mobileNumber).perform();
        automationExercisePage.createAccountButton.click();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(automationExercisePage.accountCreatedElement.isDisplayed());
        automationExercisePage.continueButton.click();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(automationExercisePage.loggedinAsElementi.isDisplayed());

        //12.Click 'Cart' button
        automationExercisePage.cartButton.click();

        //13. Click 'Proceed To Checkout' button
        automationExercisePage.proceedToCheckout.click();

        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(automationExercisePage.adressDeteailsElement.isDisplayed());
        Assert.assertTrue(automationExercisePage.reviewYourOrderElement.isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'


        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        //20. Click 'Continue' button
        //21. Click 'Delete Account' button
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
