package techproed.tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day16_positifLogIn {

    /*
    USER STORY 1
    •Name:
    Admin Login

	•Description:
	User should be able login as admin

	•Acceptance Criteria:
	•As admin, I should be able to log in the application

	https://www.bluerentalcars.com/
    Admin email: admin@bluerentalcars.com
	Admin password: 12345
     */
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @Test
    public void adminLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage =new LoginPage();
        defaultPage = new DefaultPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_admin_name"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_admin_password"));
        loginPage.loginButton.click();
        //verification
        Assert.assertTrue(defaultPage.userId.isDisplayed());
        Driver.closeDriver();



    }
    @Test(groups = "smoke-group-1")
    public void custemerLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage =new LoginPage();
        defaultPage = new DefaultPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_name"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();
        //verification
        Assert.assertTrue(defaultPage.userId.isDisplayed());
        Driver.closeDriver();

    }






}

