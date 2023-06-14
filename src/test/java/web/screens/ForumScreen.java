package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.util.Wait;

import java.util.List;

public class ForumScreen {
    public static WebDriver driver;

    public ForumScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public void clickOnHyperlink(String hyperlinkName) {
        Wait.functionPassed(() -> {
            Wait.visibilityOfElementLocated(By.cssSelector(".forum__title a"));
            List<WebElement> items = driver.findElements(By.cssSelector(".forum__title a"));
            for (WebElement item : items) {
                if (item.getText().equals(hyperlinkName)) {
                    item.click();
                    return;
                }
            }
        });
    }
}
