package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement homeLoginButton;

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



}
