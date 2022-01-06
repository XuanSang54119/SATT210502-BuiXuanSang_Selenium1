package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage{

    //Locators
    private final By txtUsername = By.id("username");
    private WebElement webElement;
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@type='submit' and @title='Login']");

    //Elements
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }
    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    //Methods
    public void Login(String username, String password){

        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void LoginMultipleTimes (String username, String password, int time){
        PageFactory.initElements(Constant.WEBDRIVER,this);
        for (int i = 0; i <= time; i++) {
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
            this.getTxtUsername().clear();
        }
    }

}
