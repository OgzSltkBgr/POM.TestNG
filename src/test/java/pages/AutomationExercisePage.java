package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@class='fa fa-home']")
    public WebElement autoHomeButton;

    @FindBy (xpath = "//*[text()='Subscription']")
    public WebElement subscriptonElement;

    @FindBy (xpath = "//*[text()='Full-Fledged practice website for Automation Engineers']")
    public WebElement fullFledgedElement;

    @FindBy (xpath = "//*[@class='fa fa-angle-up']")
    public WebElement yukariCikOku;

    @FindBy (xpath = "(//*[@class='btn btn-default add-to-cart'])[3]")
    public WebElement menTshirt;

    @FindBy (xpath = "//*[text()='View Cart']")
    public  WebElement viewChart;

    @FindBy (xpath = "//*[text()='Shopping Cart']")
    public WebElement verifyChart;

    @FindBy (xpath = "//*[text()='Proceed To Checkout']")
    public WebElement proceedToCheckout;

    @FindBy (xpath = "//*[text()='Register / Login']")
    public WebElement registerLogin;

    @FindBy (xpath = "//*[@data-qa='signup-name']")
    public WebElement signUpNameBox;

    @FindBy (xpath = "//*[@id='id_gender1']")
    public WebElement genderButton;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement createAccountPasswordBox;

    @FindBy (xpath = "//*[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy (xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedElement;

    @FindBy (xpath = "//*[text()='Continue']")
    public WebElement continueButton;

    @FindBy (xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedinAsElementi;

    @FindBy (xpath = "(//*[@href=\"/view_cart\"])[1]")
    public WebElement cartButton;

    @FindBy (xpath = "//*[text()='Address Details']")
    public WebElement adressDeteailsElement;

    @FindBy (xpath = "//*[text()='Review Your Order']")
    public WebElement reviewYourOrderElement;

    @FindBy (xpath = "//*[@class='form-control']")
    public WebElement deccriptionTextBox;

    @FindBy (xpath = "Place Order")
    public  WebElement placeOrderButton;


}
