package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTicketPage extends GeneralPage {

    //locator
    private final By ddlArriveStation = By.xpath("//td//select[@name='FilterArStation']");
    private final By ddlDepartStation = By.xpath("//td//select[@name='FilterDpStation']");
    private final By txtDepartDate = By.xpath("//input[@name='FilterDpDate']");
    private final By ddlStatus = By.xpath("//td//select[@name='FilterStatus']");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

    //dynamic locator
    String linkCancelTicket = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    public WebElement getDdlArriveStation() {
        return Constant.WEBDRIVER.findElement(ddlArriveStation);
    }
    public WebElement getDdlDepartStation() {
        return Constant.WEBDRIVER.findElement(ddlDepartStation);
    }
    public WebElement getDdlStatus() {
        return Constant.WEBDRIVER.findElement(ddlStatus);
    }
    public WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }
    public WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    protected WebElement getBtnCancel(String ID,String depart, String arrive){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCancelTicket,ID,depart, arrive)));
    };

    //Methods
    public void clickCancelTicket(String ID,String depart,String arrive){
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

    public void applyFilter(String departStation, String arriveStation, String departDate, String status) {

        Select selectDepartStation = new Select(this.getDdlDepartStation());
        selectDepartStation.selectByVisibleText(departStation);

        Select selectArriveStation = new Select(this.getDdlArriveStation());
        selectArriveStation.selectByVisibleText(arriveStation);

        Select selectDepartDate = new Select(this.getTxtDepartDate());
        selectDepartDate.selectByVisibleText(departDate);

        Select selectStatus = new Select(this.getDdlStatus());
        selectStatus.selectByVisibleText(status);

        this.getBtnApplyFilter().click();
    }
}
