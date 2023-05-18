package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableRow extends WebComponent {

    private final Table table;

    TableRow(Table table, WebElement element) {
        super(element);
        this.table = table;
    }

    List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    /**
     * Gets cell from the row by column index. If there is no such column - throws
     * exception.
     *
     * @param columnIndex - number of column, starts with 0.
     * @return TableColumn
     */

    public TableCell getCell(int columnIndex) {
        if (columnIndex >= table.getHeaders().size()) {
            throw new IllegalStateException("Cannot find column number[" + columnIndex + "] in the table.");
        }
        return new TableCell(getElement().findElements(By.tagName("td")).get(columnIndex));
    }

    /**
     * Gets cell from row by column header.
     *
     * @param header - column name.
     * @return
     */
    public TableCell getCell(String header) {
        int columnIndex = table.getColumn(header).getColumnIndex();
        return getCell(columnIndex);
    }
}