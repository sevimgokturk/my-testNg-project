package techproed.tests.dataProvider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day18DataProvider2 {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @DataProvider(name="customer-login-data")
    public Object[][] dataProviderMethod() {
        Object[][] customerCrecential = {
                {"customer@bluerentalcars.com", "12345"},
                {"customer1@bluerentalcars.com", "12346"},
                {"customer2@bluerentalcars.com", "12347"},
                {"customer3@bluerentalcars.com", "12348"}
        };
        return customerCrecential;
    }
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage =new LoginPage();
        defaultPage = new DefaultPage();
        //homePage.homeLoginButton.click();
        try {
            homePage.homeLoginButton.click();
        } catch (Exception e){
//            e.printStackTrace();
        }
        try {
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        } catch (Exception e){

        }
    }

    @Test(dataProvider = "customer-login-data")
    public void customerLogin(String username, String password) throws IOException {
        login();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(defaultPage.userId.isDisplayed());
        ReusableMethods.getScreenshot("excelLoginTest");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
