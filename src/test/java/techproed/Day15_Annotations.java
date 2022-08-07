package techproed;

import org.testng.annotations.*;

public class Day15_Annotations {
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }

    @AfterClass
    public void teardown(){
        System.out.println("After Class");
    }

    @Test(priority = 2)
    public void ztest01(){
        System.out.println("Test 1");
    }
    @Test(priority = 3)
    public void test02(){
        System.out.println("Test 2");
    }
    @Test(enabled = false)//ignore the method run button is disappeared
    public void test03(){
        System.out.println("Test 3");
    }
    @Test @Ignore
    public void test04(){
        System.out.println("Test 4");
    }
    @Test(priority = 1)
    public void atest05(){
        System.out.println("Test 5");
    }
    @Test
    public void test06(){
        System.out.println("test 6");
    }

}
