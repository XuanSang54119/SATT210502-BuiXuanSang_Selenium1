package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC04 extends TestBase {

    @Test
    public void Testcase04(){
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        LoginPage loginPage = new LoginPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("Login with valid account");
        bookTicketPage.gotoLoginPage();
        loginPage.Login(Constant.USERNAME,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();

        String actualMsg = bookTicketPage.getBookTicketTitle();
        String expectedMsg = "Book Ticket";

        Assert.assertEquals(actualMsg,expectedMsg,"User is redirected to Book ticket page after logging in");
    }

}
