package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * Table - a component for tables.
 */

public class Table extends WebComponent {

    public Table(By locator) {
        super(locator);
    }

    public Table(WebElement element) {
        super(element);
    }


    /**
     * Returns rows in table on current page.
     */
    public List<WebElement> getRows() {
        return getElement().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }

    public List<WebElement> getRowsItemTable() {
        return getElement().findElement(By.tagName("tbody")).findElements(By.className("th-clr-tr"));}

    public WebElement getRowWithCheckedCheckbox() {
        return getElement().findElement(By.tagName("tbody")).findElement(By.xpath("//*[@role='checkbox' and @aria-checked='true']"));
    }

    /**
     * Returns rows number in table.
     */
    public int getRowsNumber() {
        return getRows().size();
    }

    /**
     * Returns column by header name. If there is no such column - throws exception.
     *
     * @param columnName ,
     * @return TableColumn
     */
    public TableColumn getColumn(String columnName) {
        return new TableColumn(this, columnName);
    }

    /**
     * Looks for cells with texts equal to the values given in specified
     * columns; then it returns the row with these cells or throws an exception if
     * not found.
     *
     * @param values - a map of values to find the cells, the key is the column index,
     *               the value is the value.
     * @return TableRow
     */
    private TableRow getRow(Map<Integer, String> values) {
        for (WebElement row : getRows()) {
            boolean flag = true;
            for (Map.Entry<Integer, String> entry : values.entrySet()) {
                WebElement cell = row.findElements(By.tagName("td")).get(entry.getKey());
                flag = entry.getValue().equals(cell.getText());
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return new TableRow(this, row);
            }
        }
        throw new IllegalStateException("Cannot find row specified: [" + values + "]");
    }


    /**
     * The method returns the row by its index. The header row is considered.
     * If the row index is greater than the number of rows, throws an exception.
     *
     * @param rowIndex - the row order (header row is considered), starts from 0
     * @return TableRow
     */
    public TableRow getRow(int rowIndex) {
        return functionPassed(() -> {
            List<WebElement> rows = getRowsItemTable();
            if (rows.size() == 0) {
                throw new IllegalStateException("The row number [" + rowIndex + "] does not exist in the table. The table is empty.");
            }
            if (rowIndex >= rows.size()) {
                throw new IllegalStateException("The row number [" + rowIndex + "] does not exist in the table. There are only [" + rows.size() + "] rows in the table.");
            }
            return new TableRow(this, rows.get(rowIndex));
        });
    }

    /**
     * Looks for a cell with text equals to value; then it returns the row
     * with this cell or throws the exception.
     *
     * @param value  - value to find the cell in column.
     * @param column - number of column, starts with 0.
     * @return TableRow
     */
    public TableRow getRow(String value, int column) {
        Map<Integer, String> map = new HashMap<>();
        map.put(column, value);
        return getRow(map);
    }

    /**
         * The method returns all the headers in the table.
         *
         * @return List<WebElement> - list of headers
         */
    public List<WebElement> getHeaders() {
        return functionPassed(() -> getElement().findElement(By.tagName("thead")).findElements(By.tagName("th")));
    }
    /**
     * The method returns the header row with the filter
     *
     * @return TableHeader
     */
    public TableHeader getHeader() {
        return functionPassed(() -> new TableHeader(this, getElement().findElement(By.className("th-clr-thead"))));
    }

    /**
     * Finds column index by the column name.
     *
     * @return the column index if the column with column name exists,
     * -1 if doesn't exist
     * Start with 0.
     */
    private int findColumnIndex(String columnName) {
        List<WebElement> headers = getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals(columnName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns column index by the column name.
     *
     * @param columnName - column name.
     * @return index Enumeration starts with 0.
     */
    int getColumnIndex(String columnName) {
        int index = findColumnIndex(columnName);
        if (index == -1) {
            throw new IllegalStateException("The column [" + columnName + "] doesn't exist in the table.");
        }
        return index;
    }

}