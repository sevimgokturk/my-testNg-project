package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class HomeworkLoginErrorMessage {
    /*
    Name:
    Login screen error messages
    Description:
    User should see error message when a valid email domain is not entered
    Acceptance Criteria:
    As admin or customer, I should be able to see error message, when I do not provide a complete email address in email address box
    Error Message: email must be a valid email
    WhenI enter a valid email domain, then I should not see the error message
     */
    LoginPage loginPage;
    HomePage homePage;
    @Test
    public void loginErrorMessage()  {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        loginPage=new LoginPage();
        homePage= new HomePage();
        homePage.homeLoginButton.click();
        ReusableMethods.waitForVisibility(loginPage.loginButton,3);

        loginPage.loginButton.click();
        WebElement error_message1= loginPage.error_message1;
        WebElement error_message2=loginPage.error_message2;
        Assert.assertTrue(error_message1.isDisplayed());
        Assert.assertTrue(error_message2.isDisplayed());

        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();
        Assert.assertFalse(error_message2.isDisplayed());
        Assert.assertTrue(error_message1.isDisplayed());

        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_name"));
        loginPage.loginButton.click();
        Assert.assertFalse(error_message1.isDisplayed());
        Assert.assertTrue(error_message2.isDisplayed());

        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys(Faker.instance().name().firstName());
        Assert.assertTrue(error_message1.isDisplayed());

        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys(Faker.instance().name().firstName()+"@vvv");
        Assert.assertTrue(error_message1.isDisplayed());
        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys("@hhh.jjj");
        Assert.assertTrue(error_message1.isDisplayed());
        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys("@.jjj");
        Assert.assertTrue(error_message1.isDisplayed());
        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys("nnn@.jjj");
        Assert.assertTrue(error_message1.isDisplayed());
        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys("nnnn.bbb.jjj");
        Assert.assertTrue(error_message1.isDisplayed());




        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys(Faker.instance().internet().emailAddress());
        loginPage.password.sendKeys(Faker.instance().internet().password());
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(loginPage.invalid_credentials.isDisplayed());



    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    /*
    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[1]")
    public WebElement error_message1;

    @FindBy(xpath = "(//div[@class=\"invalid-feedback\"])[2]")
    public WebElement error_message2;
     */
}
