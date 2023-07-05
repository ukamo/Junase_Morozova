package fiori.screens.common;

import eu.ibagroup.junase.web.test.WebDriverManager;
import fiori.component.Autocomplete;
import fiori.component.Button;
import fiori.component.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Navigation {

    private final Button searchButton = new Button(By.id("sf"));

    private final Input searchInput = new Input(By.name("search"));

    private final Autocomplete searchAutocomplete = new Autocomplete(By.id(String.format("searchFieldInShell-input")));

    public static WebDriver driver;

    public Navigation() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void setSearch(String value) {
        searchInput.click();
        searchInput.setText(value);
    }

    public void clickAutocompleteByName(String value) {
        searchAutocomplete.selectValue(value);
    }
}
