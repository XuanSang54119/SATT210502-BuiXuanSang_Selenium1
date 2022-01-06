package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimeTablePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {

    @Test
    public void Testcase15() {

        System.out.println("TC15 - 'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page");
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        Constant.WEBDRIVER.manage().window().maximize();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid Account");
        homePage.gotoLoginPage();
        loginPage.Login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("Click on 'Timetable' tab");
        loginPage.gotoTimeTablePage();

        System.out.println("Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");

        timeTablePage.CheckPrice("Đà Nẵng", "Sài Gòn");

        Assert.assertEquals("Ticket price from Đà Nẵng to Sài Gòn", timeTablePage.getTableHeader(), "Welcome message is not displayed as expected");
        Assert.assertEquals("310000", timeTablePage.getHSPrice(), "Ticket price is displayed as");
        Assert.assertEquals("335000", timeTablePage.getSSPrice(), "Ticket price is displayed as");
        Assert.assertEquals("360000", timeTablePage.getSSCPrice(), "Ticket price is displayed as");
        Assert.assertEquals("410000", timeTablePage.getHBPrice(), "Ticket price is displayed as");
        Assert.assertEquals("460000", timeTablePage.getSBPrice(), "Ticket price is displayed as");
        Assert.assertEquals("510000", timeTablePage.getSBCPrice(), "Ticket price is displayed as");
    }
}
