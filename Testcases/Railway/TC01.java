package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 extends TestBase {

    @Test
    public void Testcase01() {

        System.out.println("TC01 - User can login into Railway with valid username and password");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("Enter valid Email and Password/Click on 'Login' button");
        loginPage.Login(Constant.USERNAME,Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome "+ Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome msg not display as");
    }

}
