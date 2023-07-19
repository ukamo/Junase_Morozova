package fiori.component;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Component - an abstract class for custom components. It stores methods for working with elements.
 */
public abstract class Component {

    private By locator;

    private WebElement webElement;

    protected Component(By locator) {
        this.locator = locator;
    }

    protected By getLocator() {
        return locator;
    }

    /**
     * Finds the element on the web page. If there are more than one element with
     * the same locator, returns the first one.
     * <p>
     * Method is for inner purposes only, because otherwise NullPointerException
     * can be thrown.
     *
     * @return element; if there is no element with such a locator, returns null
     */
    private WebElement findElement() {
        List<WebElement> elements = WebDriverManager.currentSession().getWebDriver().findElements(locator);
        return elements.isEmpty() ? null : elements.get(0);
    }

    /**
     * Returns WebElement based on locator.
     *
     * @return element or throws IllegalStateException exception
     */
    protected WebElement getElement() {
        WebElement element = findElement();
        if (element != null) {
            return element;
        }
        throw new IllegalStateException("The element with locator [" + locator + "] was not found.");
    }
}