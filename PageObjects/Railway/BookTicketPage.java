package PageObjects.Railway;

import Common.Constant.Constant;

public class BookTicketPage extends  GeneralPage {

    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.BOOKTICKET_URL);
    }

}
