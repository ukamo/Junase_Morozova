package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

public class TableHeader extends WebComponent {

    private static final String ASCENDING = "ascending";

    private static final String DESCENDING = "descending";

    TableHeader(WebElement element) {
        super(element);
    }

    /**
     * Returns ascending or descending sorting order.
     *
     * @return ascending/descending
     */
    private String getSortingOrder() {
        return Wait.functionPassed(() -> getElement().getAttribute("aria-sort"));
    }

    /**
     * Returns column header name.
     */
    public String getColumnName() {
        return getElement().getText().trim();
    }

    /**
     * Checks if the column sorted descending. The method looks for the
     * attribute "aria-sort" and verifies if its value equals "descending".
     *
     * @return true if yes, false if no
     */
    public boolean isSortedDescending() {
        return DESCENDING.equals(getSortingOrder());
    }

    /**
     *  Checks if the column sorted ascending. The method looks for the
     *  attribute "aria-sort" and verifies if its value equals "descending".
     *
     * @return true if yes, false if no
     */
    public boolean isSortedAscending() {
        return ASCENDING.equals(getSortingOrder());
    }
}