package fiori.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableHeader extends Component{
    private final Table table;

    public TableHeader(Table table, WebElement element) {
        super(element);
        this.table = table;
    }

    /**
     * The method gets the filter input for the particular column header passed as an argument.
     *
     * @param  - the column header
     * @return Input - the filter input
     */
    private TableRow getFilterRow() {
        WebElement webElement = getElement().findElement(By.xpath("//tr[contains(@class,'th-clr-row-nsel') and descendant::*[@role='checkbox' and @aria-checked='true']]"));
        return new TableRow(table,webElement);
    }
    public Hyperlink getFilterHyperlink(String header) {
        return getFilterRow().getCell(header).getHyperlinkFromCheckedCheckbox();
    }
}
