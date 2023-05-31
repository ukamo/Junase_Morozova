package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.component.Hyperlink;
import web.component.Input;
import web.component.Label;
import web.util.Wait;

import java.util.List;


public class NavigationScreen {
    public static WebDriver driver;
    private static final Input inputSearch = new Input(By.xpath("//input[contains(@class,'fast-search__input')]"));
    private static final Input inputSearchInIframe = new Input(By.xpath("//div[contains(@class,'search__suggest-match')]/span[contains(@class,'text_match')]"));
    private static final Label searchTabsList = new Label (By.xpath("//div[contains(@class, 'search__tabs-list')]"));
    private static final String iframeSearch = "//iframe[contains(@class,'modal-iframe')]";

    private static final Hyperlink topicByHyperlink = new Hyperlink(By.xpath("//ul[contains(@class,'search__results')]"));
    public NavigationScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }
    private static final Label activeSearchTab = new Label (By.xpath("//div[contains(@class, 'search__tabs-item_active')]"));

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

    public void navigateToSearch() {
        inputSearch.click();
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> driver.switchTo().defaultContent());
    }
    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public String assertSeacrhInApp() {
        String getNameOfSearch = inputSearch.getAttribute("placeholder");
        return getNameOfSearch = getNameOfSearch.substring(0, getNameOfSearch.indexOf(" "));
    }

    public void typeInSearch(String text) {
        inputSearch.setText(text);
        inputSearch.sendKeys(Keys.ENTER);
    }

    public void swithOnIFrameFieldSearching() {
        switchToDefaultContent();
        switchToIframe(iframeSearch);
    }
    public String assertTypedText(){
        return inputSearchInIframe.getText();
    }

    public void navigateOnSectionInSearch(String section){
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
    public String assertCursorIsOnSection(){
        return activeSearchTab.getText();
    }

    public void navigateToTopicByNumber(int numberOfTopic){
        topicByHyperlink.navigateToTopicByNumber(numberOfTopic);
    }


}


