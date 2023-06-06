package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

import java.util.List;


public class NavigationScreen {
    public static WebDriver driver;

    public NavigationScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    //FIXME: the arguments should be consistent in this method and in the same method at th NavigationSteps class, i.e. sectionName
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
            List<WebElement> items = driver.findElements(By.className("catalog-navigation-list__aside-item"));
            for (WebElement item : items) {
                if (item.getText().equals(name)) {
                    item.click();
                    return;
                }
            }
        });
    }

    //FIXME: the xpath is good but can be shorten to "//div[contains(@class, 'aside-item_active')]//span[contains(@class, 'title')]"
    // either you can use cssSelector ".catalog-navigation-list__aside-item_active .catalog-navigation-list__dropdown-title"
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


}


