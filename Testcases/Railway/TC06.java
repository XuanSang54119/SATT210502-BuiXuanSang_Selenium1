package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.ContactPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {

    @Test
    public void Testcase06(){
        System.out.println("TC06 - User is redirected to Home page after logging out");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ContactPage contactPage = new ContactPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid Email and Password");
        homePage.gotoLoginPage();

        loginPage.Login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Click on 'Contact' tab");
        loginPage.gotoContactPage();

        System.out.println("Click on 'Logout' tab");
        contactPage.gotoLogoutPage();

        Assert.assertTrue(homePage.isHomePageTitleDisplayed());
        Assert.assertFalse(homePage.isTabLogoutDisplayed());
    }
}
