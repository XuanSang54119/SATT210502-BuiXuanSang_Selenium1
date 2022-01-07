package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GeneralPage {

    //locator
    private WebElement webElement;
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabHome = By.xpath("//div[@id='menu']//a[@href = '. ./']");
    private final By tabRegister = By.xpath("//a[@href= '/Account/Register.cshtml']");
    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By lblBookTicketTitle = By.xpath("//div[@id='content']/h1[@align='center']");
    private final By lblRegisterMessage = By.xpath("//div[@id='content']/p");
    private final By lblRegisterErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblChangePasswordErrorMessage = By.xpath("//p[@class='message error']");
    private final By lblFilterErrorMessage = By.xpath("//div[@class='error message']");
    private final By lblHomePageTitle = By.xpath("//div//h1[@align='center' and text()='Welcome to Safe Railway']");


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
    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    protected WebElement getTabMyTicket() { return Constant.WEBDRIVER.findElement(tabMyTicket); }
    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);}
    protected WebElement getLblFilterErrorMessage() { return Constant.WEBDRIVER.findElement(lblFilterErrorMessage);}
    protected WebElement getLblBookTicketTitle() { return Constant.WEBDRIVER.findElement(lblBookTicketTitle); }
    protected WebElement getLblRegisterMessage() { return Constant.WEBDRIVER.findElement(lblRegisterMessage); }
    protected WebElement getLblChangePasswordErrorMessage() { return Constant.WEBDRIVER.findElement(lblChangePasswordErrorMessage); }
    protected WebElement getLblRegisterErrorMessage() { return Constant.WEBDRIVER.findElement(lblRegisterErrorMessage); }
    protected WebElement getLblHomePageTitle() { return Constant.WEBDRIVER.findElement(lblHomePageTitle); }

        //Methods
    public String getWelcomeMessage() { return this.getLblWelcomeMessage().getText(); }
    public String getLoginErrorMsg() { return this.getLblLoginErrorMsg().getText(); }
    public String getBookTicketTitle() { return this.getLblBookTicketTitle().getText(); }
    public String getRegisterMessage() {return this.getLblRegisterMessage().getText(); }
    public String getChangePasswordErrorMessage() {return this.getLblChangePasswordErrorMessage().getText(); }
    public String getRegisterErrorMessage() {return this.getLblRegisterErrorMessage().getText(); }
    public String getFilterErrorMessage() {return this.getLblFilterErrorMessage().getText(); }
    public String getHomePageTitle() {return this.getLblHomePageTitle().getText(); }


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

    public void gotoTimeTablePage(){ this.getTabTimeTable().click(); }

    public void gotoMyTicketPage() { this.getTabMyTicket().click(); }

    public boolean isHomePageTitleDisplayed() { return this.getLblHomePageTitle().isDisplayed(); }

    public boolean isTabLogoutDisplayed()
    {
        try
        {
            boolean isDisplayed = getTabLogout().isDisplayed();
            return isDisplayed;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}