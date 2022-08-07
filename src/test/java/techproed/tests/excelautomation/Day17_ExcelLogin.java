package techproed.tests.excelautomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day17_ExcelLogin {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;
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

    @Test
    public void customerLogin() throws IOException {
        String path ="./src/test/java/resources/mysmoketestdata.xlsx";
        String customerSheet = "customer_info";
        excelUtil=new ExcelUtil(path,customerSheet);
        testData= excelUtil.getDataList();
        for (Map<String,String> eachData : testData){
            login();
            loginPage.username.sendKeys(eachData.get("username"));
            String password = eachData.get("password").substring(0,5);
            loginPage.password.sendKeys(password);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(2);
            //Driver.getDriver().navigate().back();
            Assert.assertTrue(defaultPage.userId.isDisplayed());
            ReusableMethods.getScreenshot("excelLoginTest");
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
