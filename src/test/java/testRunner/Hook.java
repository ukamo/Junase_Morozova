package testRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
                if (item.equals("@web")) {
                    WebDriverManager.newSession();
                }
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
                if (item.equals("@web")) {
                    screenshot = ((TakesScreenshot) WebDriverManager.currentSession().getWebDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "screenshot"); // stick it in the report
                    FileUtil.deleteTempDirectory();
                    //WebDriverManager.closeSession();
                }
                break;
            }
        }
    }
}