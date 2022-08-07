package techproed.tests.smokeTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Dsy16_negativeLogin {
    /*
    USER STORY 3

Name: Login screen error messages

Description:
User should see error message when user tries to login with incorrect credentials
Acceptance Criteria:
As admin or customer, I should be able to see error message, when I do not provide a correct email address or password in a pop up window
Error Message: invalid credentials
     */
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void custemerLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage =new LoginPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(Faker.instance().internet().emailAddress());
        loginPage.password.sendKeys(Faker.instance().internet().password());
        loginPage.loginButton.click();
        ReusableMethods.waitForVisibility(loginPage.invalid_credentials,5);
        Assert.assertTrue(loginPage.invalid_credentials.isDisplayed());


    }



}
