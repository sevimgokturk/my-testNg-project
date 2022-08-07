package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TestAdresLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day15_LoginTest {
    TestAdresLoginPage testAdresLoginPage = new TestAdresLoginPage();
    @Test(groups = "smoke-group-1")
    public void loginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("address_url"));
        testAdresLoginPage.username.sendKeys(ConfigReader.getProperty("address_username"));
        testAdresLoginPage.password.sendKeys(ConfigReader.getProperty("address_pass"));
        testAdresLoginPage.signInButton.click();
        Driver.closeDriver();
    }
}
