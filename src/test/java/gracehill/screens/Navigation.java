package gracehill.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation {

    private static final String APPLICATION_IFRAME_ID = "iframe";

    public static WebDriver driver;

    public Navigation() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframeId(String iFrameId) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(iFrameId)));
    }

    public void switchApplicationIframe() {
        switchToDefaultContent();
        switchToIframeId(APPLICATION_IFRAME_ID);
    }
}
