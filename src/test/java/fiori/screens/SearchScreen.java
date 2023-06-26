package fiori.screens;

import eu.ibagroup.junase.web.util.Wait;
import fiori.component.TabContainer;
import org.openqa.selenium.By;

public class SearchScreen {

    private TabContainer tabList = new TabContainer(By.xpath("//div[@role='list']"));

    public boolean isContainerByNameDisplayed(String containerName) {
        return Wait.functionPassed(() -> tabList.isTabDisplayed(containerName));
    }

    public void clickContainerByName(String containerName) {
        Wait.functionPassed(() -> tabList.switchTo(containerName));
    }
}
