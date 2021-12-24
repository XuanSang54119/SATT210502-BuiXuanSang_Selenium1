package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.BookTicketPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC04 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


    @Test
    public void Testcase04(){
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        LoginPage loginPage = bookTicketPage.gotoLoginPage();

        String actualMsg = loginPage.Login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome "+ Constant.USERNAME;
        

        //Assert.assertEquals(actualMsg,expectedMsg);
    }

}
