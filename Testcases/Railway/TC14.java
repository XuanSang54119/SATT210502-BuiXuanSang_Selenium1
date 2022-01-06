package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Common.JsonHelper;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class TC14 extends TestBase {

    @Test (dataProvider = "data-provider")
    public void Testcase14(String departDate, String departFrom, String arriveAt, String seatType,String ticketAmount) {

        System.out.println("TC14 - User can book many tickets at a time");
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid account");
        loginPage.Login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Click on 'Book ticket' tab");
        loginPage.gotoBookTicketPage();

        bookTicketPage.bookTicket(departDate,departFrom,arriveAt,seatType,ticketAmount);

        Assert.assertEquals(bookTicketPage.getSuccessMessage(),"Ticket Booked Successfully!","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartFromSuccessMessage(),"Nha Trang","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getArriveAtSuccessMessage(),"Sài Gòn","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getSeatTypeSuccessMessage(),"Soft seat with air conditioner","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountSuccessMessage(),"5","Welcome message is not displayed as expected");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getDataPath();
        JsonObject jsonObject = Common.Common.JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC14.get("departDate").getAsString();
        String departFrom= dataTC14.get("departFrom").getAsString();
        String arriveAt = dataTC14.get("arriveAt").getAsString();
        String seatType = dataTC14.get("seatType").getAsString();
        String ticketAmount = dataTC14.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt,seatType,ticketAmount}
        };
        return object;
    }

}
