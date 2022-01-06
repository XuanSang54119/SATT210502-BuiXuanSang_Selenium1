package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class TC07 extends TestBase {

    @Test
    public void Testcase07() {

        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("scroll(0, 250)");

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("Enter valid information into all fields");
        registerPage.Register("Hello@gmail.com", "123456789", "123456789", "2468013579");

        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg,expectedMsg,"New account is created, Error message is displayed as");
    }
}
