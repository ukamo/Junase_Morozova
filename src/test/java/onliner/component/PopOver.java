package onliner.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * PopOver - a custom component for pop-up with question and buttons to answer.
 */
public class PopOver extends Component {

    public PopOver(By locator) {
        super(locator);
    }

    public Button getButtonByName(String buttonName) {
        List<WebElement> buttons = getElement().findElements(By.xpath("//div[contains(@class,'offers-form')]/span"));
        for (WebElement button : buttons) {
            if (button.getText().contains(buttonName)) {
                return new Button(button);
            }
        }
        throw new IllegalStateException("Cannot locate button with name [" + buttonName + "]");
    }
}