package fiori.component;


import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * TableColumn - an abstract entity, which is a reference to the table column.
 */
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

    /**
     * The method looks for cells with texts equal to the values given in specified
     * columns; then it returns the row with these cells or throws an exception if
     * not found.
     *
     * @param value - a map of values to find the cells, the key is the column index,
     *              the value is the value.
     * @return TableRow
     */
    public TableRow getRow(String value) {
        return functionPassed(() -> table.getRow(value, getColumnIndex()));
    }
}
