package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonSignInPage {
     /*
        Amazon Sign In
    -----------------------
    Go to the Amazon website
    Click on sign in button
    Send e mail by using faker
    Click on continue
    Assert "There was a problem"  message
    Click on help button
    Click on "Forgot your Password?"
    Verify the text "Password assistance"
    Navigate back
    Click on create account button
    Verify the text "Create account"
     */


    public AmazonSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy( id = "nav-link-accountList-nav-line-1")
    public WebElement signInTab;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;
    @FindBy(xpath = "//h4")
    public WebElement warningbutton;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement needHelp;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//h1")
    public WebElement passwordAssistance;

    @FindBy(id = "createAccountSubmit")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h1")
    public WebElement createAccountText;
    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchedProduct;




}
