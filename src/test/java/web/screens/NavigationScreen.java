package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.component.Input;
import web.component.Label;
import web.util.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavigationScreen {

    private static final Label activeSearchTab = new Label(By.xpath("//div[contains(@class, 'search__tabs-item_active')]"));

    public static WebDriver driver;

    public NavigationScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void navigateToSection(String name) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElement(By.className("b-top-navigation")).findElements(By.className("b-main-navigation__link"));
            for (WebElement item : items) {
                if (item.getText().equals(name)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateToFirstLevel(String name) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//li[@class ='catalog-navigation-classifier__item ']"));
            for (WebElement item : items) {
                if (item.getText().equals(name)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateToSecondLevel(String name) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class,'catalog-navigation-list__aside-title')]"));
            for (WebElement item : items) {
                if (item.getText().equals(name)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateToThirdLevel(String name) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]"));
            for (WebElement item : items) {
                if (item.getText().equals(name)) {
                    item.click();
                    return;
                }
            }
        });
    }

    public void navigateOnSectionInSearch(String section) {
        Wait.functionPassed(() -> {
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 'search__tabs-item')]"));
            for (WebElement item : items) {
                if (item.getText().equals(section)) {
                    item.click();
                    return;
                }
            }
        });
    }
    public String assertTabIsActive() {
        return activeSearchTab.getText();
    }
}


