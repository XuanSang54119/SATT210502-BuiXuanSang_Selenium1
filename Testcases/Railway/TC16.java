package Testcases.Railway;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Constant.Constant;

public class TC16 extends TestBase {

    @Test
    public void Testcase16() {

        System.out.println("TC16 - User can cancel a ticket");
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        Constant.WEBDRIVER.manage().window().maximize();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid Account");
        loginPage.Login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Click on 'My Ticket' tab");
        loginPage.gotoMyTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.cancelTicket("1", "Quảng Ngãi", "Sài Gòn");
        Assert.assertFalse(myTicketPage.isBtnCancelDisplayed("1", "Quảng Ngãi", "Sài Gòn"));
    }
}

