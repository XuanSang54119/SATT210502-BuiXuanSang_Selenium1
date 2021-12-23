package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {
    //locator
    private final By loc_tabLogin = By.xpath("//div[@id='menu']//a[@href = '/Account/Login.cshtml']");

    private WebElement webElement;
    private final By loc_tabLogout = By.xpath("//div[@id='menu']//a[@href = '/Account/Logout']");
    private final By loc_tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By loc_lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    private final By loc_lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");


    //Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(loc_tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(loc_tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(loc_tabBookTicket);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(loc_lblWelcomeMessage);
    }

    protected WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(loc_lblLoginErrorMsg);}


    //Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public String getLoginErrorMsg(){
        return this.getLblLoginErrorMsg().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
}