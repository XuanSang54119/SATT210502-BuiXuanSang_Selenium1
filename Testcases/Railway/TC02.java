package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02 extends TestBase {

    @Test
    public void Testcase02(){
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println("User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox");
        loginPage.Login("",Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg,expectedMsg,"Error msg is displayed as");
    }

}
