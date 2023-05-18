package web.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.component.Label;
import web.util.Wait;
import eu.ibagroup.junase.web.test.WebDriverManager;

import java.util.List;

public class Navigation {

    private final Label titleLabel = new Label(By.tagName("h5"));

    public void navigateToModule(String name) {
        Wait.functionPassed(() -> {
            if ("Automation Processes".equals(name)) {
                List<WebElement> items = WebDriverManager.currentSession().getWebDriver().findElement(By.id("sidebar_list")).findElements(By.className("MuiButtonBase-root"));
                for (WebElement item : items) {
                    if (item.getAttribute("aria-label").equals(name)) {
                        item.click();
                    }
                }
            }
        });
    }

    public String getScreenTitle() {
        return titleLabel.getText().split("\n")[0];
    }
}