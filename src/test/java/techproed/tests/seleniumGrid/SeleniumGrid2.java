package techproed.tests.seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid2 {

    WebDriver driver;
    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions());
        driver.get("https://www.bluerentalcars.com/");
        Thread.sleep(3000);
        String customerService = driver.findElement(By.xpath("//*[text()='Customer Services']")).getText();
        System.out.println(customerService);
        System.out.println("current thread" + Thread.currentThread());
        System.out.println(driver.getTitle());
        driver.quit();
    }





}
