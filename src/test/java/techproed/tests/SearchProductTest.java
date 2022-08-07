package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.SearchProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class SearchProductTest {
    SearchProductPage searchProductPage= new SearchProductPage();
    @Test
    public void searchProductTest(){
        //Launch browser
        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexercise_url"));
        //Verify that home page is visible successfully
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.automationexercise.com/",url);
        //Click on 'Products' button
        searchProductPage.product.click();
        //Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProduct = searchProductPage.allProduct;
        Assert.assertTrue(allProduct.isDisplayed());
        // Enter product name in search input and click search button
        searchProductPage.searchBox.sendKeys("Blue Top");
        searchProductPage.searchButton.click();
        // Verify 'SEARCHED PRODUCTS' is visible
        WebElement Search = searchProductPage.blueTopName;
        Assert.assertTrue(Search.isDisplayed());
        //Verify all the products related to search are visible
        WebElement category= searchProductPage.category;
        Assert.assertTrue(category.isDisplayed());
        WebElement brandPolo= searchProductPage.brandPolo;
        Assert.assertTrue(brandPolo.isDisplayed());
        Driver.closeDriver();




    }
}
