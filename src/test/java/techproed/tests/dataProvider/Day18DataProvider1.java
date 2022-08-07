package techproed.tests.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day18DataProvider1 {
    @DataProvider(name="customer-login-data")
    public Object[][] dataProviderMethod() {
        Object[][] customerCrecential = {
                {"customer@bluerentalcars.com", "12345"},
                {"customer1@bluerentalcars.com", "12346"},
                {"customer2@bluerentalcars.com", "12347"},
                {"customer3@bluerentalcars.com", "12348"}
        };
        return customerCrecential;
    }

    @Test(dataProvider = "customer-login-data",groups = "smoke-group-1")
    public void customerLoginInfo(String username, String password) {
        System.out.println("username: "+ username+ " | password: "+password);
    }
}



