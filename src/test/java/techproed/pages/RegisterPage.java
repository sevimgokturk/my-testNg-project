package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement  signup1;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement newUserSignup;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement name;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement email;

    @FindBy(xpath = "//section[@id='form']/div/div/div[3]/div/form/button")
    public WebElement signup2;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement information;

    @FindBy(id = "uniform-id_gender1")
    public WebElement gender;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement days;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(xpath = "//select[@id=\"years\"]")
    public WebElement years;

    @FindBy(id="newsletter")
    public WebElement newsletter;

    @FindBy(id="optin")
    public WebElement optin;

    @FindBy(id="first_name")
    public WebElement firstname;

    @FindBy(id="last_name")
    public WebElement lastname;

    @FindBy(id="company")
    public WebElement company;

    @FindBy(id="address1")
    public WebElement address1;

    @FindBy(id="address2")
    public WebElement address2;

    @FindBy(id="country")
    public WebElement country;

    @FindBy(id="state")
    public WebElement state;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="zipcode")
    public WebElement zipcode;

    @FindBy(id="mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    public WebElement createAccount;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement accountCreated;

    @FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
    public WebElement continue2;

    @FindBy(xpath = "(//a)[10]/b")
    public WebElement logegd;

    @FindBy(linkText = "Delete Account")
    public WebElement delete1;

    @FindBy(linkText ="ACCOUNT DELETED!" )
    public WebElement accountDeleted;









//*[@id="header"]/div/div/div/div[2]/div/ul/li[9]/a/b






}
