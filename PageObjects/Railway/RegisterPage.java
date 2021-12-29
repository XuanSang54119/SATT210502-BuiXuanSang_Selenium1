package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locators
    private final By txtEmail = By.id("email");
    private WebElement webElement;
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");

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

    //Methods
    public void Register(String email, String password, String confirmpassword, String pid){

        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();
    }

}
