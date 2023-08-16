package fiori.screens.common;

import fiori.component.Button;
import org.openqa.selenium.By;

public class Footer {

    private final Button detailsButton = new Button(By.id("th-mes-inf-cont"));

    public void clickSuccessButton() {
        detailsButton.click();
    }

    public boolean isSuccessButtonDisplayed() {
        return detailsButton.isDisplayed();
    }

}
