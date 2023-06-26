package fiori.screens;

import fiori.component.Button;
import fiori.component.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomeScreen {

    private static final String SEARCH_INPUT_XPATH = "//input[contains(@placeholder,'%s')]";

    private static final String SEARCH_BUTTON = "//a[@title='%s']";

    public void clickIconByName(String iconName) {
        new Button(By.xpath(String.format(SEARCH_BUTTON, iconName))).click();
    }

    public void setValue(String value, String iconName) {
        Input input = new Input(By.xpath(String.format(SEARCH_INPUT_XPATH, iconName)));
        input.click();
        input.setText(value);
        input.sendKeys(Keys.ENTER);

    }
}
