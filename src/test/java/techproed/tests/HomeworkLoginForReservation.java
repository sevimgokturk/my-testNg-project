package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HomeworkLoginForReservation {
    /*
    Name:
    Require user to login for reservation
    Description:
    User should see a message when user tries to book a car while not logged in
    Acceptance Criteria:
    As customer, I should be able to see error message, when I try to book a car while not logged in
    Message: Please first login
    Given user is on the login page
    And tries to book a car
    And click continue reservation
    Then user see the warning message: Please first login
     */
    HomePage homePage;
    @Test
    public void loginForeReservationErrorMessage(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        WebElement carDropdown = homePage.dropdown_select_car;
        Select select1 = new Select(carDropdown);
        ReusableMethods.selectRandomTextFromDropdown(select1);
        WebElement pickUpLocation = homePage.dropdown_pickUpLocation;

        pickUpLocation.sendKeys("cali");
        List<WebElement> pickUpLocationList = Driver.getDriver().findElements(By.xpath("(//ul)[2]//li"));
        Random random = new Random();
        WebElement random1PickUpLocation = pickUpLocationList.get(random.nextInt(pickUpLocationList.size()-1));
        random1PickUpLocation.click();
        WebElement dropOffLocation = homePage.dropdown_dropOfLocation;
        dropOffLocation.sendKeys("cali");
        List<WebElement> dropOffLocationList = Driver.getDriver().findElements(By.xpath("(//ul)[3]//li"));
        WebElement random2PickUpLocation = dropOffLocationList.get(random.nextInt(pickUpLocationList.size()-1));
        random2PickUpLocation.click();
        LocalDate from1 =LocalDate.now();
        LocalDate to1 = LocalDate.now().plusYears(1);
        long days = from1.until(to1, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate1 = from1.plusDays(randomDays);
        String pickupDate = randomDate1.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        homePage.pickUpDate.sendKeys(pickupDate);
        LocalDate from2 =randomDate1;
        LocalDate to2 = randomDate1.plusYears(1);
        long days2 = from2.until(to2, ChronoUnit.DAYS);
        long randomDays2 = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate2 = from2.plusDays(randomDays2);
        String dropOffDate = randomDate2.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        homePage.dropOffDate.sendKeys(dropOffDate);
        String h1 = String.valueOf(Faker.instance().number().numberBetween(0,24));
        String m1 = String.valueOf(Faker.instance().number().numberBetween(0 ,59));
        List<String> amPmList= new ArrayList<>();
        amPmList.add("AM");
        amPmList.add("PM");
        String amPm= amPmList.get(random.nextInt(amPmList.size()-1));
        String time = h1+":"+m1+amPm;
        homePage.pickUpTime.sendKeys(time);
        String h2 = String.valueOf(Faker.instance().number().numberBetween(0,24));
        String m2 = String.valueOf(Faker.instance().number().numberBetween(0 ,59));
        String amPm2= amPmList.get(random.nextInt(amPmList.size()-1));
        String time2 = h2+":"+m2+amPm2;
        homePage.dropOffTime.sendKeys(time2);
        homePage.continue_reservation.click();
        ReusableMethods.waitForVisibility(homePage.allert_pleaseLogin,3);
        Assert.assertTrue(homePage.allert_pleaseLogin.isDisplayed());
        ReusableMethods.waitFor(2);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    /*
    @FindBy(xpath = "//select[@name=\"car\"]")
    public WebElement dropdown_select_car;

    @FindBy(xpath = "//input[@name=\"pickUpLocation\"]")
    public WebElement dropdown_pickUpLocation;

    @FindBy(xpath ="//input[@name=\"dropOfLocation\"]" )
    public WebElement dropdown_dropOfLocation;

    @FindBy(xpath = "//input[@name=\"pickUpDate\"]")
    public WebElement pickUpDate;

    @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;

    @FindBy(xpath = "//input[@name=\"dropOffDate\"]")
    public WebElement dropOffDate;

    @FindBy(xpath = "//input[@name=\"dropOffTime\"]")
    public WebElement dropOffTime;

    @FindBy(xpath = "//button[@class=\"w-100 btn btn-primary btn-lg\"]")
    public WebElement continue_reservation;

    @FindBy(xpath = "//*[text()='Please first login']")
    public WebElement allert_pleaseLogin;

     */

}
