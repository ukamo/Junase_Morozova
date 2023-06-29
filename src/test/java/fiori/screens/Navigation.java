package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import fiori.component.Autocomplete;
import fiori.component.Button;
import fiori.component.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Navigation {

    private final Button searchButton = new Button(By.xpath("//a[@title='Search']"));

    private final Input searchInput = new Input(By.xpath("//input[(@name='search')]"));

    private final Autocomplete searchAutocomplete = new Autocomplete(By.xpath(String.format("//div[@id='searchFieldInShell-input']")));


    public static WebDriver driver;

    public Navigation() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void setValueByPlaceholder(String value) {
        searchInput.click();
        searchInput.setText(value);
    }

    public void waitAutocompleteIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//tbody[contains(@class,'sapMListItems')]")))
                .isDisplayed();
    }

    public void clickAutocompleteByName(String autocompleteName) {
        searchAutocomplete.selectValue(autocompleteName);
    }
}
