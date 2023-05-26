package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * This class contains all Session-specific variables.
 */
public class Session {

    private final WebDriver webDriver;

    private final WebDriverWait webDriverWait;

    private final String loginUrl;

    private final String displayResolution;

    private final String sessionId;

    Session(String loginUrl, WebDriver webDriver, int timeout, String displayResolution, String sessionId) {
        this.loginUrl = loginUrl;
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        this.webDriverWait = new WebDriverWait(webDriver, (long) timeout);
        this.displayResolution = displayResolution;
        this.sessionId = sessionId;
    }

    /**
     * Method navigates to loginUrl.
     */
    void start() {
        getWebDriver().get(loginUrl);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public String getSessionId() {
        return sessionId;
    }
}
