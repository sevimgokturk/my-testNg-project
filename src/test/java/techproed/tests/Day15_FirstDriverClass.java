package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day15_FirstDriverClass {
    @Test
    public void firstDriverClass(){
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.closeDriver();

    }
    @Test
    public void prporitiesFileTest(){
        System.out.println(ConfigReader.getProperty("google_url"));
        System.out.println(ConfigReader.getProperty("browser"));
        System.out.println(ConfigReader.getProperty("techproed_url"));
        System.out.println(ConfigReader.getProperty("username"));


    }

}
