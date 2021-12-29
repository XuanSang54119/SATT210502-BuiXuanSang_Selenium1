package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private WebElement webElement;
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");

    //Elements
    protected WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }
    protected WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }
    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    //Methods
    public void ChangePassword(String currentpword, String newpword, String confirmpwword) {

        this.getTxtCurrentPassword().sendKeys(currentpword);
        this.getTxtNewPassword().sendKeys(newpword);
        this.getTxtConfirmPassword().sendKeys(confirmpwword);
        this.getBtnChangePassword().click();
    }
}
