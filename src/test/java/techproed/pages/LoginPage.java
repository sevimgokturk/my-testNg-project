package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id="formBasicEmail")
    public WebElement username;

    @FindBy(id="formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='invalid credentials']\n")
    public  WebElement invalid_credentials;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[1]")
    public WebElement error_message1;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[2]")
    public WebElement error_message2;



}
