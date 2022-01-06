package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {

    @Test
    public void Testcase08() {

        System.out.println("TC08 - User can't login with an account hasn't been activated");
        System.out.println("Pre-condition: Create a new account but do not activate it");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("Enter username and password of account hasn't been activated.");
        loginPage.Login("Sang@gmail.com","123456789");

        Assert.assertFalse(homePage.isHomePageTitleDisplayed());

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"User cannot login");
    }
}
