package fiori.screens.common;

import eu.ibagroup.junase.web.test.WebDriverManager;
import fiori.component.Autocomplete;
import fiori.component.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation {

    private final Button searchButton = new Button(By.id("sf"));

    private final Autocomplete searchAutocomplete = new Autocomplete(By.id("searchFieldInShell-input-inner"));

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

    public void clickAutocompleteByName(String value) {
        searchAutocomplete.selectValue(value);
    }
}
