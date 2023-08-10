package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * TableRow - a component for the table cells, <td> tag.
 */
public class TableCell extends WebComponent {

    protected TableCell(WebElement element) {
        super(element);
    }

    /**
     * The method gets the hyperlink from the table cell.
     *
     * @return Hyperlink
     */
    public Hyperlink getHyperlink() {
        return functionPassed(() -> new Hyperlink(getElement().findElement(By.className("th-tx-value"))));
        //return functionPassed(() -> new Hyperlink(getElement().findElement(By.className("th-clr-cel"))));
    }

    /**
     * The method gets the hyperlink by checkbox from the table cell.
     *
     * @return Hyperlink
     */
    public Hyperlink getHyperlinkByCheckbox() {
        return functionPassed(() -> new Hyperlink(getElement().findElement(By.className("th-sapcb"))));
    }

    /**
     * The method gets the input from the table cell.
     *
     * @return Input
     */
    public Input getInput() {
        return functionPassed(() -> new Input(getElement().findElement(By.tagName("input"))));
    }

    /**
     * The method gets the checkbox from the table cell.
     *
     * @return CheckBox
     */
    public Checkbox getCheckbox() {
        return functionPassed(() -> new Checkbox(getElement().findElement(By.className("th-sapcb-a"))));
    }
    public void setTextWithEnter(String value){
        Input input = this.getInput();
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }
}
