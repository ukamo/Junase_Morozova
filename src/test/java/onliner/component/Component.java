package onliner.component;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Component - an abstract class for custom components. It stores methods for working with elements.
 */
public abstract class Component {

    private By locator;

    protected Component(By locator) {
        this.locator = locator;
    }

    private WebElement findElement() {
        List<WebElement> elements = WebDriverManager.currentSession().getWebDriver().findElements(locator);
        return elements.isEmpty() ? null : elements.get(0);
    }

    protected WebElement getElement() {
        WebElement element = findElement();
        if (element != null) {
            return element;
        }
        throw new IllegalStateException("The element with locator [" + locator + "] was not found.");
    }

    public boolean isDisplayed() {
        WebElement webElement = findElement();
        return webElement != null && webElement.isDisplayed();
    }
}