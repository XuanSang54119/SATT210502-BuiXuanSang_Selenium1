package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC03 extends TestBase {

    @Test
    public void Testcase03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("Enter valid Email and invalid Password");
        loginPage.Login(Constant.USERNAME,"vn");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error msg display as");
    }

}
