package techproed.tests;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.RegisterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterTest {
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void registerTest() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexercise_url"));
        // Verify that home page is visible successfully
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.automationexercise.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
        // Click on 'Signup / Login' button
        registerPage.signup1.click();
        //Verify 'New User Signup!' is visible
        Thread.sleep(2000);
        WebElement newUserSignUpIsDisplayed = registerPage.newUserSignup;
        Assert.assertTrue(newUserSignUpIsDisplayed.isDisplayed());
        //Enter name and email address
        String name= Faker.instance().name().firstName();
        registerPage.name.sendKeys(name);
        String email = Faker.instance().internet().emailAddress();
        registerPage.email.sendKeys(email);
        //Click 'Signup' button
        registerPage.signup2.click();
        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement information= registerPage.information;
        Assert.assertTrue(information.isDisplayed());
        // Fill details: Title, Name, Email, Password, Date of birth
        registerPage.gender.click();
        String password = Faker.instance().internet().password();
        registerPage.password.sendKeys(password);

        String day = String.valueOf(Faker.instance().number().numberBetween(1,30));
        Select select1 = new Select(registerPage.days);
        select1.selectByValue(day);

        String month = String.valueOf(Faker.instance().number().numberBetween(1,12));
        Select select2 = new Select(registerPage.months);
        select2.selectByValue(month);

        //String year = String.valueOf(Faker.instance().number().numberBetween(1950,2005));
        //Select select3 = new Select(registerPage.years);
        //select2.selectByVisibleText(year);
        registerPage.years.sendKeys("1950");

        //Select checkbox 'Sign up for our newsletter!'
        registerPage.newsletter.click();
        //Select checkbox 'Receive special offers from our partners!'
        registerPage.optin.click();
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.firstname.sendKeys(name);
        String lastname= Faker.instance().name().lastName();
        registerPage.lastname.sendKeys(lastname);
        String company= Faker.instance().company().name();
        registerPage.company.sendKeys(company);
        String adresses1= Faker.instance().address().fullAddress();
        registerPage.address1.sendKeys(adresses1);
        String adresses2 = Faker.instance().address().secondaryAddress();
        registerPage.address2.sendKeys(adresses2);
        String country = Faker.instance().address().country();
        registerPage.country.sendKeys(country);
        String state = Faker.instance().address().state();
        registerPage.state.sendKeys(state);
        String city = Faker.instance().address().city();
        registerPage.city.sendKeys(city);
        String zip = Faker.instance().address().zipCode();
        registerPage.zipcode.sendKeys(zip);
        String mobilNumber= Faker.instance().phoneNumber().toString();
        registerPage.mobileNumber.sendKeys(mobilNumber);
        // Click 'Create Account button'
        registerPage.createAccount.click();
        // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = registerPage.accountCreated;
        Assert.assertTrue(accountCreated.isDisplayed());
        //Click 'Continue' button
        registerPage.continue2.click();
        //Verify that 'Logged in as username' is visible
        String logged = registerPage.logegd.getText();
        Assert.assertEquals(name,logged);
        //Click 'Delete Account' button
        registerPage.delete1.click();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        SoftAssert softAssert = new SoftAssert();
        WebElement accountDeleted = registerPage.accountDeleted;
        softAssert.assertTrue(accountDeleted.isDisplayed());//this case failed manually too!!!!

    }
    @AfterMethod
    public void screenShot() throws IOException {
        File img = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"test-image.png";
        File finalPath = new File(path);
        FileUtils.copyFile(img,finalPath); // source, destination
        boolean isexist= Files.exists(Paths.get(path));
        Assert.assertTrue(isexist);
    }


}
