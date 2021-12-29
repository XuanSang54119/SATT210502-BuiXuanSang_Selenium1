package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {

    @Test
    public void Testcase10() {

        System.out.println("TC10 - User can't create account with an already in-use email");
        System.out.println("TPre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("Enter information of the created account in Pre-condition");
        registerPage.Register(Constant.USERNAME, "123456789", "123456789", "2468013579");

        String actualMsg = registerPage.getRegisterErrorMessage();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg,expectedMsg,"New account is not created");
    }

}
