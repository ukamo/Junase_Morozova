package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class NavigationScreen {

    private static final String searchInputXpath = "//input[contains(@placeholder,'%s')]";

    private static final String searchButton = "//a[@title='%s']";

    private static final String iframeCommon = "//iframe[@title = 'Application']";

    private static final String iframeDialog = "//iframe[@id='thDialogIframe_1']";

    private static final String iframeSelectTransactionType = "//iframe[@id='WorkAreaFrame1popup']";

    private static final String typeTransaction = "//*[@title='%s']";

    private static final String divByRole = "//div[@role='%s']";

    private TabContainer tabList = new TabContainer(By.xpath("//div[@role='list']"));

    private Table tableMain = new Table(By.xpath("//div[@id='_POPUP0001']/table"));

    private Table tableTypes = new Table(By.xpath("//table[contains(@id,'Table_TableHeader')]"));

    public static WebDriver driver;

    public NavigationScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void clickIconByName(String iconName) {
        new Button(By.xpath(String.format(searchButton, iconName))).click();
    }

    public void setValue(String value, String iconName) {
        Input input = new Input(By.xpath(String.format(searchInputXpath, iconName)));
        input.click();
        input.setText(value);
        input.sendKeys(Keys.ENTER);

    }

    public boolean isContainerByNameDisplayed(String name) {
        return Wait.functionPassed(() -> tabList.isTabDisplayed(name));
    }

    public void clickContainerByName(String value) {
        Wait.functionPassed(() -> tabList.switchTo(value));
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public void switсhIFrameSelectTransactionType() {
        switchToDefaultContent();
        switchToIframe(iframeCommon);
        switchToIframe(iframeDialog);
        switchToIframe(iframeSelectTransactionType);
    }

    public void switсhIFrameCommon() {
        switchToDefaultContent();
        switchToIframe(iframeCommon);
    }

    public void switсhIFrameTransactionType() {
        switchToIframe(iframeDialog);
        switchToIframe(iframeSelectTransactionType);
    }

    public boolean isDialogOpened(String dialogType) {
        return new Dialog(By.xpath(String.format(divByRole, dialogType))).isDisplayed();
    }

    public boolean isTableDisplayed() {
        return tableMain.isDisplayed() & tableTypes.isDisplayed();
        //return tableMain.isDisplayed();
        //return  tableTypes.isDisplayed();
    }

    public int getRowsNumber() {
        return tableTypes.getRowsNumber();
    }

    public String getModalWindowText() {
        //table.getRow(rowIndex).getCell(columnHeader).click()
        //tableMain.getRow(0).getCell(0);
        //tableHeader.getRow(0).getCell(0).getText();
        return tableMain.getRow(0).getCell(0).getText();
    }

    public void clickTransactionType(String type) {
        new Input(By.xpath(String.format(typeTransaction, type))).click();
    }
}
