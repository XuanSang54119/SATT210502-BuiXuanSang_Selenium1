package Testcases.Railway;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    @Test
    public void Testcase11() {

        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("Enter valid email address and leave other fields empty");
        registerPage.Register("Hello@gmail.com", "", "", "");

        String actualMsg = registerPage.getLoginErrorMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"New account is not created");
    }
}
