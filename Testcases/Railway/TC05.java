package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {

    @Test
    public void Testcase05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("Login 3 times by entering valid information into 'Username' textbox except 'Password' textbox.");
        loginPage.LoginMultipleTimes (Constant.USERNAME, "hello", 3);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is displayed as");
    }
}
