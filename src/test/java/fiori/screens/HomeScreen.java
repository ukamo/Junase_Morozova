package fiori.screens;

import fiori.component.Button;
import fiori.component.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomeScreen {

    private static final String INPUT_BY_PLACEHOLDER_XPATH = "//input[contains(@Placeholder,'%s')]";

    private static final String BUTTON_BY_TITLE = "//a[@title='%s']";

    public void clickIconByTitle(String iconTitle) {
        new Button(By.xpath(String.format(BUTTON_BY_TITLE, iconTitle))).click();
    }

    public void setValueByPlaceholder(String value, String title) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_PLACEHOLDER_XPATH, title)));
        input.click();
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }
}
