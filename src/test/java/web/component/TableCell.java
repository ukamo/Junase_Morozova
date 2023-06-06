package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.util.Wait;

public class TableCell extends WebComponent {

    /**
     * Used to pass WebElement.
     */
    protected TableCell(WebElement element) {
        super(element);
    }

    /**
     * The method gets the value from the table cell.
     *
     * @return String text
     */
    public String getValue() {
        return Wait.functionPassed(() -> getElement().getText());
    }

    /**
     * The method gets the input from the table cell.
     *
     * @return Input
     */
    public Input getInput() {
        return Wait.functionPassed(() -> new Input(getElement().findElement(By.tagName("input"))));
    }

    /**
     * The method gets the dropdown from the table cell.
     *
     * @return Dropdown
     */
    public Dropdown getDropdown() {
        return new Dropdown(getElement().findElement(By.tagName("select")));
    }

    /**
     * The method gets the checkbox from the table cell.
     *
     * @return CheckBox
     */
    public CheckBox getCheckBox() {
        return Wait.functionPassed(() -> new CheckBox(getElement().findElement(By.className("checkbox"))));
    }

    /**
     * The method gets the hyperlink from the table cell.
     *
     * @return Hyperlink
     */
    public Hyperlink getHyperlink() {
        return Wait.functionPassed(() -> new Hyperlink(getElement().findElement(By.tagName("a"))));
    }

    public Input getElementP() {
        return Wait.functionPassed(() ->
                new Input(
                        getElement().findElement(By.xpath("//p[1]"))));
    }


}