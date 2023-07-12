package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * TableRow - a component for the table cells, <td> tag.
 */
public class TableCell extends WebComponent {

    protected TableCell(WebElement element) {
        super(element);
    }

    /**
     * The method gets the hyperlink from the table cell.
     *
     * @return Hyperlink
     */
    public Hyperlink getHyperlink() {
        return functionPassed(() -> new Hyperlink(getElement().findElement(By.className("th-tx-value"))));
    }
}
