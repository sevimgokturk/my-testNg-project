package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day15_firstConfigTest {
    @Test
    public void firestConfigTest(){
        Driver.getDriver().get(ConfigReader.getProperty("techproed_url"));
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        Driver.closeDriver();
    }

}
