package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
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

    /**
     * The method check the checkbox is.
     *
     * @return boolean
     */
    public boolean isCheckbox(){
        try {
            new Checkbox(getElement().findElement(By.className("th-sapcb-a")));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * The method check the Input is.
     *
     * @return boolean
     */
    public boolean isInput(){
        try {
            new Input (getElement().findElement(By.cssSelector("input"))).getValue();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
