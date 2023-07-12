package onliner.component;

import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Sidebar - a custom component for right-side dropout panel.
 */
public class Sidebar extends Component {

    public Sidebar(By locator) {
        super(locator);
    }

    public List<String> getSubHeaders() {
        return Wait.functionPassed(() -> {
            List<String> headerNames = new ArrayList<>();
            for (WebElement header : getElement().findElements(By.className("product-recommended__subheader"))) {
                headerNames.add(header.getText());
            }
            return headerNames;
        });
    }
}