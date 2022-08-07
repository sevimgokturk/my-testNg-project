package techproed;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day15_Assertions {
    @Test
    public void hardAssert(){//assertion
        //when assertion fails than test case stops execution
        System.out.println("Line 9");//run
        System.out.println("Line 10");//run
        Assert.assertEquals(3,4);//run but fails
        System.out.println("Line 13");//not run
        Assert.assertEquals(2,2);//not run
        System.out.println("Line 14");// not run
    }
    @Test
    public void TestCase(){
        System.out.println("Line19");
    }
    @Test(dependsOnMethods = "hardAssert")
    public void dependendMethodDemo(){
        System.out.println("Line24");
        System.out.println("Line25");
    }

    @Test
    public void softAssert(){ //verification
        System.out.println("Line 29");
        System.out.println("Line 30");
        SoftAssert  softAssert= new SoftAssert();
        softAssert.assertEquals(5,4);
        System.out.println("Line 33");
        softAssert.assertEquals(2,2);
        System.out.println("Line 35");
        softAssert.assertAll(); //Expected :4  if we dont write assertAll(); all assertions look as pass
                                //Actual   :5
    }

}
