package gracehill.component;

import org.openqa.selenium.WebElement;

import java.util.List;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

public class TableColumn {
    private int columnIndex = -1;

    private final Table table;

    private final String columnName;

    public TableColumn(Table table, String columnName) {
        this.table = table;
        this.columnName = columnName;
    }

    /**
     * Returns column index by the column name.
     *
     * @return index Enumeration starts with 0.
     */
    int getColumnIndex() {
        if (columnIndex == -1) {
            columnIndex = table.getColumnIndex(columnName);
        }
        return columnIndex;
    }

    public TableRow getRow(String value) {
        return functionPassed(() -> table.getRow(value, getColumnIndex()));
    }

    public TableRow getRow(int rowIndex) {
        return functionPassed(() -> {
            List<WebElement> rows = table.getRows();
            if (rows.size() == 0) {
                throw new IllegalStateException("The row number [" + rowIndex + "] does not exist in the table. The table is empty.");
            }
            if (rowIndex >= rows.size()) {
                throw new IllegalStateException("The row number [" + rowIndex + "] does not exist in the table. There are only [" + rows.size() + "] rows in the table.");
            }
            return new TableRow(table, rows.get(rowIndex));
        });
    }

    public TableRow getRowN(String value, String columnName) {
        List<WebElement> rows = table.getRows();
        for (WebElement row : rows) {
            if (this.getRow(rows.indexOf(row)).getCell(columnName).getText().equals(value)) {
                return getRow(rows.indexOf(row));
            }
        }
        throw new IllegalStateException("Cannot find row specified: [" + value + "]");
    }
}
