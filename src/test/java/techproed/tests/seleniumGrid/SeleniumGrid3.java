package techproed.tests.seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid3 {

    WebDriver driver;
    @Test
    public void test3() throws MalformedURLException, InterruptedException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://www.bluerentalcars.com/");
        Thread.sleep(3000);
        String customerService = driver.findElement(By.xpath("//*[text()='Customer Services']")).getText();
        System.out.println(customerService);
        System.out.println("current thread" + Thread.currentThread());
        //        1 thread means => one execution path
//        What does this currentThread() returns us, when executed?
//        It will return us the reference of currently executing threat object
//        currentThread() method tells us which is the current thread executing
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
