package PageObjects.Railway;

import Common.Constant.Constant;

public class ContactPage extends GeneralPage {

    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.CONTACT_URL);
    }

}
