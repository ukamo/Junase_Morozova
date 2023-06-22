package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.component.*;

public class NavigationScreen {

    private static final String searchInputXpath = "//input[contains(@placeholder,'%s')]";

    private static final String searchButton = "//a[@title='%s']";

    private static final String tabLabel = "//a[contains(@aria-label,'%s')]";

    private static final String iframeCommon = "//iframe[@title = 'Application']";
    private static final String iframeDialog = "//iframe[@id='thDialogIframe_1']";
    private static final String iframeSelectTransactionType = "//iframe[@id='WorkAreaFrame1popup']";

    private static final String typeTransaction = "//*[@title='%s']";
    private Table tableMain = new Table (By.xpath("//div[@id='_POPUP0001']/table"));

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
        new Input(By.xpath(String.format(searchInputXpath, iconName))).setText(value);
    }

    public void clickTabByName(String tabName) {
        new TabContainer(By.xpath(String.format(tabLabel, tabName))).click();
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

    public String getModalWindowText() {
        //table.getRow(rowIndex).getCell(columnHeader).click()
        //tableMain.getRow(0).getCell(0);
       //tableHeader.getRow(0).getCell(0).getText();
        return tableMain.getRow(0).getCell(0).getText();
    }

    public void navigateType(String type){
        new Input(By.xpath(String.format(typeTransaction, type))).click();
    }

}
