package fiori.screens;

import fiori.component.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ServiceOrderQuotationScreen {

    private static final String INPUT_BY_LABEL_XPATH = "//label[contains(text(),'%s')]//following::input[1]";

    public void setInputByLabel(String labelName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_LABEL_XPATH, labelName)));
        input.setText(value);
    }

    public void setInputByLabelAndClickEnter(String labelName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_LABEL_XPATH, labelName)));
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }
}
