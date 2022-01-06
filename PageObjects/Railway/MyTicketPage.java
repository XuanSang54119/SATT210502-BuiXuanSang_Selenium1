package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTicketPage extends GeneralPage {

    //dynamic locator
    String cancelTicketLink = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getBtnCancel(String ID,String depart, String arrive){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(cancelTicketLink,ID,depart, arrive)));
    };

    //Methods
    public void cancelTicket(String ID,String depart,String arrive){
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getBtnCancel(ID,depart,arrive)));
        this.getBtnCancel(ID,depart,arrive).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public boolean isBtnCancelDisplayed(String ID,String depart,String arrive){
        try {
            return this.getBtnCancel(ID, depart, arrive).isDisplayed();
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }
}
