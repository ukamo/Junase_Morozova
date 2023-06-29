package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dialog extends WebComponent {

    public Dialog(By locator) {
        super(locator);
    }

    public Dialog(WebElement element) {
        super(element);
    }
}