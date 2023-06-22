package fiori.component;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModalWindow extends Component {

    private By locator;

    public ModalWindow(By locator) {
        super(locator);
    }

    private static WebDriver getWebDriver() {
        return WebDriverManager.currentSession().getWebDriver();
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
        List<WebElement> elements = getWebDriver().findElements(locator);
        return elements.isEmpty() ? null : elements.get(0);
    }
    /**
     * Method checks if the component is displayed on the page.
     *
     * @return true - if it is displayed<br>
     * false in any other case
     */
    public boolean isDisplayedModal() {
        WebElement webElement = findElement();
        return webElement != null && webElement.isDisplayed();
    }
}
