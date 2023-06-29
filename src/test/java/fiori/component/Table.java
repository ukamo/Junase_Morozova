package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table extends WebComponent {

    public Table(By locator) {
        super(locator);
    }

    /**
     * Returns rows in table on current page.
     */
    private List<WebElement> getRows() {
        List<WebElement> rows = getElement().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        return rows;
    }

    /**
     * Returns rows number in table.
     */
    public int getRowsNumber() {
        return getRows().size();
    }
}