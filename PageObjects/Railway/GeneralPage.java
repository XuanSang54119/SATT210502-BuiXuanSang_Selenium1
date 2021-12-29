package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GeneralPage {

    //locator
    private WebElement webElement;
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href = '/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href = '/Account/Logout']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href = '/Page/Contact.cshtml']");
    private final By tabHome = By.xpath("//div[@id='menu']//a[@href = '. ./']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href = '/Account/Register.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By lblBookTicketTitle = By.xpath("//div[@id='content']/h1[@align='center']");
    private final By lblRegisterMessage = By.xpath("//div[@id='content']/p");
    private final By lblRegisterErrorMessage = By.xpath("//p[@class='message error']");


    //Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }
    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }
    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);}
    protected WebElement getLblBookTicketTitle() { return Constant.WEBDRIVER.findElement(lblBookTicketTitle); }
    protected WebElement getLblRegisterMessage() { return Constant.WEBDRIVER.findElement(lblRegisterMessage); }
    protected WebElement getLblRegisterErrorMessage() { return Constant.WEBDRIVER.findElement(lblRegisterErrorMessage); }

        //Methods
    public String getWelcomeMessage() { return this.getLblWelcomeMessage().getText(); }
    public String getLoginErrorMsg() { return this.getLblLoginErrorMsg().getText(); }
    public String getBookTicketTitle() { return this.getLblBookTicketTitle().getText(); }
    public String getRegisterMessage() {return this.getLblRegisterMessage().getText(); }
    public String getRegisterErrorMessage() {return this.getLblRegisterErrorMessage().getText(); }

    public void gotoLoginPage(){
        this.getTabLogin().click();
    }

    public void gotoLogoutPage(){
        this.getTabLogout().click();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket().click();
    }

    public void gotoContactPage(){
        this.getTabContact().click();
    }

    public void gotoHomePage(){
        this.getTabHome().click();
    }

    public void gotoRegisterPage(){
        this.getTabRegister().click();
    }

    public void gotoChangePasswordPage(){
        this.getTabChangePassword().click();
    }

}