package web.component;

import eu.ibagroup.junase.web.util.Wait;

import java.util.List;

public class TableColumn {

    private int columnIndex = -1;

    private final Table table;

    private final String columnName;

    public TableColumn(Table table, String columnName) {
        this.table = table;
        this.columnName = columnName;
    }

    int getColumnIndex() {
        if (columnIndex == -1) {
            columnIndex = table.getColumnIndex(columnName);
        }
        return columnIndex;
    }

    public TableCell getCell(String value) {
        return Wait.functionPassed(() -> table.getCell(value, getColumnIndex()));
    }

    public TableRow getRow(String value) {
        return Wait.functionPassed(() -> table.getRow(value, getColumnIndex()));
    }

    public List<String> getValues() {
        return Wait.functionPassed(() -> table.getValues(getColumnIndex()));
    }

    public TableHeader getHeader() {
        return Wait.functionPassed(() -> {
            int index = getColumnIndex();
            return new TableHeader(table.getHeaders().get(index));
        });
    }
}