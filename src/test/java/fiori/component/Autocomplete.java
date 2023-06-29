package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Autocomplete extends WebComponent {

    public Autocomplete(By locator) {
        super(locator);
    }

    public Autocomplete(WebElement element) {
        super(element);
    }

    public void selectValue(String value) {
        Wait.functionPassed(() -> {
            for (WebElement element : getElement().findElements(By.xpath("//tbody[contains(@class,'sapMListItems')]//span"))) {
                if (element.getText().contains(value)) {
                    element.click();
                    return;
                }
            }
            throw new IllegalStateException("Cannot locate element with text [" + value + "]");
        });
    }
}
