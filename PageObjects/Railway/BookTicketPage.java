package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends  GeneralPage {

    // Locators
    private final By ddlDepartDate = By.xpath("//li//select[@name='Date']");
    private final By ddlDepartFrom = By.xpath("//li//select[@name='DepartStation']");
    private final By ddlArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//li//select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//li//select[@name='TicketAmount']");
    private final By ddlDepartDateSuccess = By.xpath("//tr[@class='OddRow']//td[4]");
    private final By ddlDepartFromSuccess = By.xpath("//tr[@class='OddRow']//td[1]");
    private final By ddlArriveAtSuccess = By.xpath("//tr[@class='OddRow']//td[2]");
    private final By ddlSeatTypeSuccess = By.xpath("//tr[@class='OddRow']//td[3]");
    private final By ddlTicketAmountSuccess = By.xpath("//tr[@class='OddRow']//td[7]");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblSuccessMessage = By.xpath("//h1[@align ='center']");
    private final By lblBookTicketErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblTicketAmountErrorMsg = By.xpath("//select[@name='TicketAmount']/../label[@class='validation-error']");

    // Elements
    public WebElement getDdlDepartDate() {
        return Constant.WEBDRIVER.findElement(ddlDepartDate);
    }
    public WebElement getDdlDepartFrom() {
        return Constant.WEBDRIVER.findElement(ddlDepartFrom);
    }
    public WebElement getDdlArriveAt() {
        return Constant.WEBDRIVER.findElement(ddlArriveAt);
    }
    public WebElement getDdlSeatType() {
        return Constant.WEBDRIVER.findElement(ddlSeatType);
    }
    public WebElement getDdlTicketAmount() {
        return Constant.WEBDRIVER.findElement(ddlTicketAmount);
    }
    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
    public WebElement getLblSuccessMessage() {
        return Constant.WEBDRIVER.findElement(lblSuccessMessage);
    }
    public WebElement getDdlDepartDateSuccess() {
        return Constant.WEBDRIVER.findElement(ddlDepartDateSuccess);
    }
    public WebElement getDdlDepartFromSuccess() {
        return Constant.WEBDRIVER.findElement(ddlDepartFromSuccess);
    }
    public WebElement getDdlArriveAtSuccess() { return Constant.WEBDRIVER.findElement(ddlArriveAtSuccess); }
    public WebElement getDdlSeatTypeSuccess() {
        return Constant.WEBDRIVER.findElement(ddlSeatTypeSuccess);
    }
    public WebElement getDdlTicketAmountSuccess() {
        return Constant.WEBDRIVER.findElement(ddlTicketAmountSuccess);
    }
    public WebElement getLblBookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);
    }
    public WebElement getLblTicketAmountErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblTicketAmountErrorMsg);
    }

    // Method
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        Select selectDepartDate = new Select(this.getDdlDepartDate());
        selectDepartDate.selectByVisibleText(departDate);

        Select selectDepartFrom = new Select(this.getDdlDepartFrom());
        selectDepartFrom.selectByVisibleText(departFrom);

        Select selectSeatType = new Select(this.getDdlSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Select selectTicketAmount = new Select(this.getDdlTicketAmount());
        selectTicketAmount.selectByVisibleText(ticketAmount);

        try {
            Select selectArriveAt = new Select(this.getDdlArriveAt());
            selectArriveAt.selectByVisibleText(arriveAt);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            Select selectArriveAt = new Select(this.getDdlArriveAt());
            selectArriveAt.selectByVisibleText(arriveAt);
        }

        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        Constant.WEBDRIVER.manage().window().maximize();
        jse.executeScript("scroll(0, 250)");
        this.getBtnBookTicket().click();
    }

    public String getSuccessMessage() {
        return getLblSuccessMessage().getText();
    }

    public String getDepartDateSuccessMessage() {
        return getDdlDepartDateSuccess().getText();
    }

    public String getDepartFromSuccessMessage() {
        return getDdlDepartFromSuccess().getText();
    }

    public String getArriveAtSuccessMessage() {
        return getDdlArriveAtSuccess().getText();
    }

    public String getSeatTypeSuccessMessage() {
        return getDdlSeatTypeSuccess().getText();
    }

    public String getTicketAmountSuccessMessage() {
        return getDdlTicketAmountSuccess().getText();
    }

    public String getBookTicketErrorMsg() { return getLblBookTicketErrorMsg().getText(); }

    public String getTicketAmountErrorMsg() { return getLblTicketAmountErrorMsg().getText(); }

}
