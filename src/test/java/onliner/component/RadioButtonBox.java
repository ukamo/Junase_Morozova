package onliner.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * RadioButtonBox - a model.component for a radio button box with several radio buttons {@link RadioButton}.
 */
public class RadioButtonBox extends WebComponent {

    public RadioButtonBox(By locator) {
        super(locator);
    }

    public RadioButtonBox(WebElement element) {
        super(element);
    }

    /**
     * Select the radio button with the corresponding label.
     *
     * @param radioButtonLabel - the name of the radio button to select
     */
    public void select(String radioButtonLabel) {
        List<WebElement> labels = getElement().findElements(By.tagName("label"));
        for (WebElement label : labels) {
            if (label.getText().equals(radioButtonLabel)) {
                label.click();
                return;
            }
        }
        throw new IllegalStateException("Cannot locate radio button with label [" + radioButtonLabel + "]");
    }

    /**
     * Returns selected value from the radio button box.
     *
     * @return String selectedValue
     */
    public String getSelectedValue() {
        List<WebElement> labels = getElement().findElements(By.tagName("label"));
        List<WebElement> radioButtons = getElement().findElements(By.tagName("input"));
        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).isSelected()) {
                return labels.get(i).getText();
            }
        }
        throw new IllegalStateException("Cannot locate selected radio button");
    }

    @Override
    public RadioButtonBox scrollToElement() {
        return (RadioButtonBox) super.scrollToElement();
    }
}