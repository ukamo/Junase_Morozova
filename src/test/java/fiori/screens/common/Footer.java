package fiori.screens.common;

import fiori.component.Button;
import fiori.component.ButtonsContainer;
import org.openqa.selenium.By;

public class Footer {
    public final String savedTransactionMessage = "th-mess-cont-toast";
    private final Button detailsButton = new Button(By.id("th-mes-inf-cont"));

    private final ButtonsContainer footerContainer = new ButtonsContainer(By.id("tbOVFcontainerwafooter"));

    public void clickSuccessButton() {
        detailsButton.click();
    }

    public boolean isSuccessButtonDisplayed() {
        return detailsButton.isDisplayed();
    }

    public void clickButtonByNameOnFooter(String buttonName) {
        footerContainer.getButtonByName(buttonName).jsClick();
    }
}
