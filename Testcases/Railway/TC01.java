package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC01 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1080,720));//maximize();

    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


    @Test
    public void Testcase01() {
        System.out.println("TC01 - User can login into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();


        LoginPage loginPage = homePage.gotoLoginPage();


        String actualMsg = loginPage.Login("",Constant.PASSWORD).getLoginErrorMsg();
        String expectedMsg = "Welcome "+ Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome msg not display as.");
    }

}
