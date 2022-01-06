package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {

    @Test
    public void Testcase11() {

        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("scroll(0, 250)");

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("Enter valid email address and leave other fields empty");
        registerPage.Register("Hello@gmail.com", "", "", "");

        String actualMsg = registerPage.getRegisterErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        String actualMsgPassword = registerPage.getPasswordErrorMessage();
        String expectedMsgPassword = "Invalid password length";

        String actualMsgPID = registerPage.getPIDErrorMessage();
        String expectedMsgPID = "Invalid ID length";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsgPassword, expectedMsgPassword, "Error message is not displayed as expected");
        Assert.assertEquals(actualMsgPID, expectedMsgPID, "Error message is not displayed as expected");

    }
}
