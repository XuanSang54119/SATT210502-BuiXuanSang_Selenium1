package Testcases.Railway;

import Common.Common.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Common.Constant.Constant;

public class TC17 extends TestBase {

    @Test(dataProvider = "data-provider")
    public void Testcase17 (String departDate1, String departFrom1, String arriveAt1, String seatType1, String ticketAmount1,
                            String departDate2, String departFrom2, String arriveAt2, String seatType2, String ticketAmount2,
                            String departDate3, String departFrom3, String arriveAt3, String seatType3, String ticketAmount3,
                            String departDate4, String departFrom4, String arriveAt4, String seatType4, String ticketAmount4) {
        System.out.println("TC17 - User can't book more than 10 tickets");
        System.out.println("Pre-condition: Create and activate a new account");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid Account");
        loginPage.Login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Click on 'Book Ticket' tab");
        loginPage.gotoBookTicketPage();

        System.out.println("Book 10 Tickets");
        bookTicketPage.bookTicket(departDate1, departFrom1, arriveAt1, seatType1, ticketAmount1);
        bookTicketPage.bookTicket(departDate2, departFrom2, arriveAt2, seatType2, ticketAmount2);
        bookTicketPage.bookTicket(departDate3, departFrom3, arriveAt3, seatType3, ticketAmount3);

        System.out.println("Click on 'Book Ticket' tab again");
        loginPage.gotoBookTicketPage();

        System.out.println("Book 1 more ticket");
        bookTicketPage.bookTicket(departDate4, departFrom4, arriveAt4, seatType4, ticketAmount4);

        Assert.assertEquals(bookTicketPage.getBookTicketErrorMsg(), "There're errors in the form. Please correct the errors and try again.", "Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountErrorMsg(), "You have booked 10 tickets. You can book no more.", "Welcome message is not displayed as expected");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getDataPath();
        JsonObject jsonObject = Common.Common.JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC17.get("departDate1").getAsString();
        String departFrom1 = dataTC17.get("departFrom1").getAsString();
        String arriveAt1 = dataTC17.get("arriveAt1").getAsString();
        String seatType1 = dataTC17.get("seatType1").getAsString();
        String ticketAmount1 = dataTC17.get("ticketAmount1").getAsString();

        String departDate2 = dataTC17.get("departDate2").getAsString();
        String departFrom2 = dataTC17.get("departFrom2").getAsString();
        String arriveAt2 = dataTC17.get("arriveAt2").getAsString();
        String seatType2 = dataTC17.get("seatType2").getAsString();
        String ticketAmount2 = dataTC17.get("ticketAmount2").getAsString();

        String departDate3 = dataTC17.get("departDate1").getAsString();
        String departFrom3 = dataTC17.get("departFrom1").getAsString();
        String arriveAt3 = dataTC17.get("arriveAt1").getAsString();
        String seatType3 = dataTC17.get("seatType1").getAsString();
        String ticketAmount3 = dataTC17.get("ticketAmount1").getAsString();

        String departDate4 = dataTC17.get("departDate1").getAsString();
        String departFrom4 = dataTC17.get("departFrom1").getAsString();
        String arriveAt4 = dataTC17.get("arriveAt1").getAsString();
        String seatType4 = dataTC17.get("seatType1").getAsString();
        String ticketAmount4 = dataTC17.get("ticketAmount1").getAsString();

        Object[][] object = new Object[][]{
                {departDate1, departFrom1, arriveAt1, seatType1, ticketAmount1,
                 departDate2, departFrom2, arriveAt2, seatType2, ticketAmount2,
                 departDate3, departFrom3, arriveAt3, seatType3, ticketAmount3,
                 departDate4, departFrom4, arriveAt4, seatType4, ticketAmount4,}
        };

        return object;
    }
}
