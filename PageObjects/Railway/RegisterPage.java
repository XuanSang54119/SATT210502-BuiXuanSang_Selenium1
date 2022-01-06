package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends GeneralPage {

    //Locators
    private final By txtEmail = By.id("email");
    private WebElement webElement;
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblPasswordErrorMessage = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblPIDErrorMessage = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }
    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }
    protected WebElement getLblPasswordErrorMessage() { return Constant.WEBDRIVER.findElement(lblPasswordErrorMessage); }
    protected WebElement getLblPIDErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblPIDErrorMessage);
    }

    //Methods
    public void Register(String email, String password, String confirmPassword, String pid){

        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPid().sendKeys(pid);
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getBtnRegister()));
        element.click();
    }

    public String getPasswordErrorMessage() {
        return getLblPasswordErrorMessage().getText();
    }
    public String getPIDErrorMessage() {
        return getLblPIDErrorMessage().getText();
    }

}
