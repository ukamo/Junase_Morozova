package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import web.util.Wait;

import java.util.List;

/**
 * Input - a model.component for inputs and text areas. Allows to set random values.
 */
public class Input extends WebComponent {

    public Input(By locator) {
        super(locator);
    }

    public Input(WebElement element) {
        super(element);
    }

    /**
     * Cleans the input field and sets the text.
     *
     * @param value - text to set
     */
    public void setText(String value) {
        Wait.functionPassed(() -> {
            clear();
            sendKeys(value);
        });
    }

    /**
     * Cleans the input field.
     */
    public void clear() {
        getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    /**
     * Sets the text to the input field.
     *
     * @param value - text to set
     */
    public void sendKeys(String value) {
        Wait.functionPassed(() -> getElement().sendKeys(value));
    }

    /**
     * Sends the keys to the input field.
     *
     * @param key - keys to set
     */
    public void sendKeys(Keys key) {
        getElement().sendKeys(key);
    }

    /**
     * Checks if the input field is empty.
     */
    public boolean isEmpty() {
        return getElement().getAttribute("value").isEmpty();
    }

    @Override
    public Input scrollToElement() {
        return (Input) super.scrollToElement();
    }

    public String gatherPriceByNumber(int numberOfButton) {
            List<WebElement> listOfElements = getElement().findElements(By.xpath("//div[contains(@class,'offers-list__description_alter-other')]"));
            return listOfElements.get(numberOfButton-1).getText();
    }


}