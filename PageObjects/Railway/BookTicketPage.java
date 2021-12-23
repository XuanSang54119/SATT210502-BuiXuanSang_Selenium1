package PageObjects.Railway;

import Common.Constant.Constant;

public class BookTicketPage extends  GeneralPage {

    //Locators
    //Elements
    //Methods
    public BookTicketPage open(){
        Constant.WEBDRIVER.navigate().to(Constant.BOOKTICKET_URL);
        return this;
    }

}
