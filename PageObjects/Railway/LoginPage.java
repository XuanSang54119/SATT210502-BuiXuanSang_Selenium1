package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends  GeneralPage{


    //Locators
    private final By loc_txtUsername = By.xpath("//input[@id='username']");

    private WebElement webElement;
    private final By loc_txtPassword = By.xpath("//input[@id='password']");
    private final By loc_btnLogin = By.xpath("//input[@value='login']");



    //Elements
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(loc_txtUsername);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(loc_txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(loc_btnLogin);
    }





    //Methods
    public HomePage Login(String name, String password){
        //Submit login
        this.getTxtUsername().sendKeys(name);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        //land on the Home Page
        return new HomePage();
    }

}
