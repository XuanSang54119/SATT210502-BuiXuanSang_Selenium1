package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {

    @Test
    public void Testcase09() {

        System.out.println("TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.");
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changepasswordPage = new ChangePasswordPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.Login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Click on 'Change Password' tab");
        loginPage.gotoChangePasswordPage();
        changepasswordPage.ChangePassword(Constant.USERNAME, "Vietnamvodich", "Vietnamkovodich");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg,expectedMsg,"User cannot login");
    }
}
