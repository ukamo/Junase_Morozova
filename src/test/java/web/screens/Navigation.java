package web.screens.Onliner;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

import java.util.List;


public class Navigation {

    public static WebDriver driver;

    public Navigation() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

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

    public void navigateToFirstLevel(String firstMenuItem) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//li[@class ='catalog-navigation-classifier__item ']"));
            for (WebElement item : items) {
                if (item.getText().equals(firstMenuItem)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateToSecondLevel(String secondMenuItem) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.className("catalog-navigation-list__aside-item"));
            for (WebElement item : items) {
                if (item.getText().equals(secondMenuItem)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateToThirdLevel(String thirdMenuItem) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'aside-item_active')]//span[contains(@class, 'title')]"));
            for (WebElement item : items) {
                if (item.getText().equals(thirdMenuItem)) {
                    item.click();
                    return;
                }
            }
        });
    }
}


