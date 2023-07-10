package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;

/**
 * Dialog - a class for dialogs.
 */
public class Dialog extends WebComponent {

    public Dialog(By locator) {
        super(locator);
    }

    /**
     * The method gets the table from the dialog.
     */
    public Table getTable() {
        return new Table(getElement().findElement(By.xpath("//table[contains(@id,'TableHeader')]")));
    }
}