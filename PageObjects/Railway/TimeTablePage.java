package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.Constant.Constant;

public class TimeTablePage extends GeneralPage {

    //Locators
    private final By txtHSPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[1]");
    private final By txtSSPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[2]");
    private final By txtSSCPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[3]");
    private final By txtHBPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[4]");
    private final By txtSBPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[5]");
    private final By txtSBCPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[6]");
    private final By txtTableHeader = By.xpath("//tr[@class='TableSmallHeader']//th");

    //Dynamic locators
    String linkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td/a[text()='check price']";

    //Elements
    protected WebElement getLinkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, depart, arrive)));
    }

    protected WebElement getTxtTableHeader() {
        return Constant.WEBDRIVER.findElement(txtTableHeader);
    }
    protected WebElement getTxtHSPrice() {
        return Constant.WEBDRIVER.findElement(txtHSPrice);
    }
    protected WebElement getTxtSSPrice() {
        return Constant.WEBDRIVER.findElement(txtSSPrice);
    }
    protected WebElement getTxtSSCPrice() {
        return Constant.WEBDRIVER.findElement(txtSSCPrice);
    }
    protected WebElement getTxtHBPrice() {
        return Constant.WEBDRIVER.findElement(txtHBPrice);
    }
    protected WebElement getTxtSBPrice() {
        return Constant.WEBDRIVER.findElement(txtSBPrice);
    }
    protected WebElement getTxtSBCPrice() {
        return Constant.WEBDRIVER.findElement(txtSBCPrice);
    }

    //Methods
    public void clickLinkCheckPrice(String depart, String arrive) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getLinkCheckPrice(depart, arrive)));
        this.getLinkCheckPrice(depart, arrive).click();
    }

    public String getHSPrice() {
        return getTxtHSPrice().getText();
    }

    public String getSSPrice() {
        return getTxtSSPrice().getText();
    }

    public String getSSCPrice() {
        return getTxtSSCPrice().getText();
    }

    public String getHBPrice() {
        return getTxtHBPrice().getText();
    }

    public String getSBPrice() {
        return getTxtSBPrice().getText();
    }

    public String getSBCPrice() {
        return getTxtSBCPrice().getText();
    }

    public String getTableHeader() {
        return getTxtTableHeader().getText();
    }
}
