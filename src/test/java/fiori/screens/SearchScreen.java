package fiori.screens;

import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Autocomplete;
import fiori.component.TabContainer;
import org.openqa.selenium.By;

public class SearchScreen {

    private final TabContainer tabByRole = new TabContainer(By.xpath("//div[@role='list']"));

    public boolean isContainerByNameDisplayed(String containerName) {
        return Wait.functionPassed(() -> tabByRole.isTabDisplayed(containerName));
    }
}
