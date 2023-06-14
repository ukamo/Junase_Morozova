package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnlinerScreen {

    public void navigateSection(String section) {
        Wait.functionPassed(() -> {
            List<WebElement> items = WebDriverManager.currentSession().getWebDriver().findElement(By.className("b-top-navigation")).findElements(By.className("b-main-navigation__link"));
            for (WebElement item : items) {
                if (item.getText().equals(section)) {
                    item.click();
                    return;
                }
            }
        });
    }
}
