package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.util.Wait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table extends WebComponent {

    public Table(By locator) {
        super(locator);
    }

    /**
     * Returns rows in table on current page.
     */
    private List<WebElement> getRows() {
        List<WebElement> rows = getElement().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        rows.remove(0);
        return rows;
    }

    private List<WebElement> getRowsOnliner() {
        List<WebElement> rows = getElement().findElements(By.tagName("tr"));
        return rows;
    }

    public List<WebElement> getHeaders() {
        return Wait.functionPassed(() -> getElement().findElement(By.tagName("thead")).findElements(By.tagName("th")));
    }

    public List<WebElement> getHeadersOnliner() {
        return Wait.functionPassed(() -> getElement().findElements(By.tagName("td")));
    }

    /**
     * Returns rows number in table.
     */
    public int getRowsNumber() {
        return getRows().size();
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
                flag = flag && entry.getValue().equals(cell.getText());
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
     * Returns row by number ONLY on current page. If the row number is more than
     * rows on the page - throws exception. Rows are without headers.
     *
     * @param row - number of row, starts with 0.
     * @return TableRow
     */
    public TableRow getRow(int row) {
        return Wait.functionPassed(() -> {
            List<WebElement> rows = getRows();
            if (rows.size() == 0) {
                throw new IllegalStateException("Row number [" + row + "] does not exist in the table. The table is empty.");
            }
            if (row >= rows.size()) {
                throw new IllegalStateException("Row number [" + row + "] does not exist in the table. There are only [" + rows.size() + "] rows on the page.");
            }
            return new TableRow(this, rows.get(row));
        });
    }

    public TableRow getRowOnliner(int row) {
        return Wait.functionPassed(() -> {
            List<WebElement> rows = getRowsOnliner();
            if (rows.size() == 0) {
                throw new IllegalStateException("Row number [" + row + "] does not exist in the table. The table is empty.");
            }
            if (row >= rows.size()) {
                throw new IllegalStateException("Row number [" + row + "] does not exist in the table. There are only [" + rows.size() + "] rows on the page.");
            }
            return new TableRow(this, rows.get(row));
        });
    }



    /**
     * Finds column index by the column name.
     *
     * @return the column index if the column with column name exists,
     * -1 if doesn't exist
     */
    private int findColumnIndex(String columnName) {
        List<WebElement> headers = getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getAttribute("innerText").trim().equals(columnName)) {
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

    /**
     * Returns column by header name. If there is no such column - throws exception.
     *
     * @param columnName
     * @return TableColumn
     */
    public TableColumn getColumn(String columnName) {
        return new TableColumn(this, columnName);
    }

    /**
     * Returns list of column names
     *
     * @return columnNames
     */
    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        List<WebElement> headers = getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            columnNames.add(headers.get(i).getText().trim());
        }
        return columnNames;
    }

    /**
     * Returns cell in the specified column with specified value.
     *
     * @param value
     * @param column
     * @return
     */
    TableCell getCell(String value, int column) {
        return new TableCell(getRow(value, column).findElements(By.tagName("td")).get(column));
    }

    /**
     * Returns cell in the specified column in specified row.
     *
     * @param row
     * @param columnName
     * @return
     */
    public TableCell getCell(int row, String columnName) {
        return getCell(row, findColumnIndex(columnName));
    }

    private TableCell getCell(int row, int column) {
        return new TableCell(getRow(row).findElements(By.tagName("td")).get(column));
    }

    /**
     * Returns list of values in specific column ONLY on current page of the
     * table. If column contains labels and input/combobox, the value will be
     * taken only from input/combobox.
     *
     * @param column Number of column, starts with 0.
     * @return list
     */
    private List<String> getValuesCurrentPage(int column) {
        List<String> list = new ArrayList<>();
        for (WebElement row : getRows()) {
            WebElement cell = row.findElements(By.tagName("td")).get(column);
            list.add(cell.getText());
        }
        return list;
    }

    /**
     * Returns list of values in specific column on all pages of the table. If
     * column contains labels and input/combobox, the value will be taken only
     * from input/combobox.
     *
     * @param column Number of column, starts with 0.
     * @return list
     */
    public List<String> getValues(int column) {
        return new ArrayList<>(getValuesCurrentPage(column));
    }

    /**
     * Returns values of the table as List of Maps. Every Map consists of
     * pairs column name + value. For checkbox columns values "Yes" and "No" are
     * applied.<br>
     * <br>
     * Use this method to assertEquals for values from DataTable. In Steps file
     * expected is:<br>
     * List<Map<String, String>> expected = dataTable.asMaps(String.class,
     * String.class); Keep in mind, that dataTable from feature file must have
     * headers exactly the same as in application.
     *
     * @return listOfMaps
     */
    public List<Map<String, String>> getValues() {
        List<Map<String, String>> listOfMaps = new ArrayList<>();
        List<String> headers = getColumnNames();
        int row = 0;
        while (row < getRowsNumber()) {
            Map<String, String> rowMap = populateRowMap(headers, row);
            if (rowMap == null) {
                return listOfMaps;
            }
            listOfMaps.add(rowMap);
            row++;
        }
        return listOfMaps;
    }

    /**
     * RowMap is a map where key is column name and value - value. Method returns null, if the row is empty.
     *
     * @param headers
     * @param row
     * @return
     */
    private Map<String, String> populateRowMap(List<String> headers, int row) {
        Map<String, String> rowMap = new HashMap<>();
        boolean isRowEmpty = true;
        for (int column = 0; column < headers.size(); column++) {
            if (!headers.get(column).isEmpty()) {
                String value = getCell(row, column).getText();
                rowMap.put(headers.get(column), value);
                isRowEmpty = isRowEmpty && (StringUtils.isEmpty(value));
            }
        }
        return isRowEmpty ? null : rowMap;
    }

    /**
     * Returns whether the table is empty. The method checks either there are
     * no rows in the table or all rows are empty.
     *
     * @return True if the table is empty, false if not.
     */
    public boolean isEmpty() {
        List<WebElement> rows = getRows();
        return rows.size() == 0;
    }

}