package web.component;

import eu.ibagroup.junase.model.component.Control;
import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.util.Wait;

import java.util.List;

/**
 * Hyperlink - a model.component for hyperlinks.
 */
public class Hyperlink extends WebComponent implements Control {

    public Hyperlink(By locator) {
        super(locator);
    }

    public Hyperlink(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        Wait.functionPassed(() -> getElement().click());
    }

    @Override
    public void rightClick() {
        Wait.functionPassed(() -> getActionBuilder().contextClick(getElement()).perform());
    }

    @Override
    public void doubleClick() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void jsClick() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Hyperlink scrollToElement() {
        return (Hyperlink) super.scrollToElement();
    }

    public static Hyperlink getDisplayedContentByTitle() {
        return Wait.functionPassed(() -> {
            List<WebElement> windows = getWebDriver().findElements(By.xpath("//title"));
            return new Hyperlink(getDisplayed((windows)));
        });
    }


    public String getContent() {
        return getElement().findElement(By.xpath("//title")).getAttribute("textContent");
    }

    public static WebElement getDisplayed(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            if (!webElement.getAttribute("textContent").isEmpty() || webElement.isDisplayed()){
                return webElement;
            }
        }
        throw new IllegalStateException("Cannot find web element on the page.");
    }
}