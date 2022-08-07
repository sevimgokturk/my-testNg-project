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
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day18DataProvider3 {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @DataProvider(name ="customer-login-data")
    public Object[][] dataProviderMethod(){
        String path ="./src/test/java/resources/mysmoketestdata.xlsx";
        String customerSheet = "customer_info";
        ExcelUtil excelUtil=new ExcelUtil(path,customerSheet);
        Object[][] customerCreds = excelUtil.getDataArrayWithoutFirstRow();
        return customerCreds;
    }
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage =new LoginPage();
        defaultPage = new DefaultPage();
        try {
            homePage.homeLoginButton.click();
        } catch (Exception e){
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
        loginPage.password.sendKeys(password.substring(0,5));
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
