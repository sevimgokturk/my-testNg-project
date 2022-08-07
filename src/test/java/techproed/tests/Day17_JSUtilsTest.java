package techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.grid.config.ConcatenatingConfig;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class Day17_JSUtilsTest {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        JSUtils.scrollIntoViewJS(Driver.getDriver().findElement(By.xpath("//a[.='Contact']")));
        ReusableMethods.waitFor(2);
        JSUtils.scrollAllUpByJS();
        JSUtils.flash(Driver.getDriver().findElement(By.linkText("Login")));

    }
}
