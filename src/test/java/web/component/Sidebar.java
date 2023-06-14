package web.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

public class Sidebar extends Component{

    public Sidebar(By locator) {
        super(locator);
    }

    public List<WebElement> getSubHeaders() {
        return functionPassed(() -> getElement().findElements(By.cssSelector(".product-recommended__subheader")));
    }
}
