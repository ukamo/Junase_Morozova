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

    public String getTopicByNumber(int numberOfButton) {
        return Wait.functionPassed(() -> getElement().findElements
                        (By.xpath("//div[contains(@class,'result__item')]/div[contains(@class,'forum__title')]/a[@target='_parent']"))
                .get(numberOfButton - 1).getText());
    }

    public void navigateTopicByNumber(int numberOfButton) {
        Wait.functionPassed(() -> {
            List<WebElement> listOfElements = getElement().findElements(By.xpath("//div[contains(@class,'result__item')]/div[contains(@class,'forum__title')]/a[@target='_parent']"));
            listOfElements.get(numberOfButton-1).click();
        });
    }
}