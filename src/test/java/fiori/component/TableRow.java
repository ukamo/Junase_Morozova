package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * TableRow - a component for the table rows, <tr> tag.
 */
public class TableRow extends WebComponent {

    private final Table table;

    TableRow(Table table, WebElement element) {
        super(element);
        this.table = table;
    }

    /**
     * The method gets the cell from the row by the column index.
     * If there is no such a column - throws exception.
     *
     * @param columnIndex - the column order, starts with 0.
     * @return TableCell
     */
    public TableCell getCell(int columnIndex) {
        return functionPassed(() -> {
            if (columnIndex >= table.getHeaders().size()) {
                throw new IllegalStateException("Cannot find column index [" + columnIndex + "] in the table.");
            }
            return new TableCell(getElement().findElements(By.tagName("td")).get(columnIndex));
        });
    }

    /**
     * The method gets the cell from the row by the column index in Item table.
     * If there is no such a column - throws exception.
     *
     * @param columnIndex - the column order, starts with 0.
     * @return TableCell
     */
    public TableCell getCellItem(int columnIndex) {
        return functionPassed(() -> {
            if (columnIndex >= table.getHeaders().size()) {
                throw new IllegalStateException("Cannot find column index [" + columnIndex + "] in the table.");
            }
            return new TableCell(getElement().findElements(By.className("th-clr-td")).get(columnIndex));
        });
    }

    /**
     * The method gets the cell from the row by the column Header.
     * If there is no such a column - throws exception.
     *
     * @param header - the column header
     * @return TableCell
     */
    public TableCell getCell(String header) {
        int columnIndex = table.getColumn(header).getColumnIndex();
        return getCell(columnIndex);
    }

    /**
     * The method gets the cell from the row by the column Header in Item table.
     * If there is no such a column - throws exception.
     *
     * @param header - the column header
     * @return TableCell
     */
    public TableCell getCellItem(String header) {
        int columnIndex = table.getColumn(header).getColumnIndex();
        return getCellItem(columnIndex);
    }
}
