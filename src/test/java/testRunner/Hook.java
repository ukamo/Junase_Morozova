package testRunner;

import eu.ibagroup.junase.desktop.test.DesktopDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import eu.ibagroup.junase.mobile.test.MobileDriverManager;
import eu.ibagroup.junase.javaApp.test.JavaDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import eu.ibagroup.junase.sap.test.SapDriverManager;
import eu.ibagroup.junase.model.util.FileUtil;
import eu.ibagroup.junase.web.test.WebDriverManager;

import java.util.Arrays;
import java.util.List;

/**
 * Before/after feature file code implementation.
 */
public class Hook {
    List<String> items = Arrays.asList("@web", "@desktop", "@mobile", "@sap", "@java", "@api");

    /**
     * Starts new session of the appropriate driver before execution of feature file.
     */
    @Before
    public void setUp(Scenario scenario) throws Exception {
        for (String item : items) {
            if (scenario.getSourceTagNames().contains(item)) {
                switch (item) {
                    case "@web":
                        WebDriverManager.newSession();
                        break;
                    case "@desktop":
                        DesktopDriverManager.newSession();
                        break;
                    case "@mobile":
                        MobileDriverManager.newSession();
                        break;
                    case "@sap":
                        SapDriverManager.newSession();
                        break;
                    case "@java":
                        JavaDriverManager.newSession();
                        break;
                }
                break;
            }
        }
    }

    /**
     * Closes session of the appropriate driver, and attaches screenshot of the last displayed
     * UI page to the report.
     */
    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot;
        for (String item : items) {
            if (scenario.getSourceTagNames().contains(item)) {
                switch (item) {
                    case "@web":
                        screenshot = ((TakesScreenshot) WebDriverManager.currentSession().getWebDriver()).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                        FileUtil.deleteTempDirectory();
                        WebDriverManager.closeSession();
                        break;
                    case "@desktop":
                        screenshot = DesktopDriverManager.currentSession().getWindowsDriver().getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                        DesktopDriverManager.closeSession();
                        break;
                    case "@mobile":
                        screenshot = ((TakesScreenshot) MobileDriverManager.currentSession().getDriver()).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                        MobileDriverManager.currentSession().getDriver().resetApp();
                        break;
                    case "@sap":
                        screenshot = SapDriverManager.currentSession().getSapDriver().getScreenshotAsBytes();
                        scenario.embed(screenshot, "image/png");
                        SapDriverManager.closeSession();
                        break;
                    case "@java":
                        screenshot = ((TakesScreenshot) JavaDriverManager.currentSession().getJavaDriver()).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                        JavaDriverManager.closeSession();
                        break;
                }
                break;
            }
        }
    }
}