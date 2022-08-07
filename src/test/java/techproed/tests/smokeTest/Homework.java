package techproed.tests.smokeTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Homework {
    HomePage homePage;
    LoginPage loginPage;
    @DataProvider(name="customer-login-data")
    public Object[][] dataProviderMethod() {
        Object[][] customerCrecentialWithInvalidEmail = {
                {"abc-@mail.com", "12345"},
                {"abc..def@mail.com", "12346"},
                {".abc@mail.com", "12347"},
                {"abc#def@mail.com", "12348"},
                {"abc.def@mail.c", "12348"},
                {"abc.def@mail#archive.com", "12348"},
                {"abc.def@mail", "12348"},
                {"abc.def@mail..com", "12348"}
        };
        return customerCrecentialWithInvalidEmail;
    }

    @Test(dataProvider = "customer-login-data")
    public void customerLoginWithInvalidEmail(String username, String password) throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        loginPage=new LoginPage();
        homePage= new HomePage();
        homePage.homeLoginButton.click();
        ReusableMethods.waitForVisibility(loginPage.loginButton,3);

        loginPage.username.sendKeys(username);
        WebElement error_message1= loginPage.error_message1;
        Assert.assertTrue(error_message1.isDisplayed());
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("loginTestHomework");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}



