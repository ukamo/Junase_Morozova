package gracehill.component;

import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideMenu extends WebComponent {
    public SideMenu(By locator) {
        super(locator);
    }

    public Button navigateToMenuItem(String menuItemName) {
        return Wait.functionPassed(() -> {
            List<WebElement> buttons = getElement().findElements(By.className("nav-item"));
            for (WebElement button : buttons) {
                if (button.getText().equals(menuItemName)) {
                    return new Button(button);
                }
            }
            throw new IllegalStateException("Cannot locate element with text [" + menuItemName + "]");
        });
    }

    /**
     * Returns the name of the active menu item from the tab container.
     */
    public String getMenuItem() {
        return getElement().findElement(By.className("active")).getText();
    }
}
