package fiori.screens;

import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Hyperlink;
import fiori.component.TabContainer;
import org.openqa.selenium.By;

public class HomeScreen {

    private final TabContainer groupTabContainer = new TabContainer(By.id("__header0-head"));

    //private final TabContainer tileTabContainer = new TabContainer(By.id("__section0-__xmlview0--pagesNavContainer-1-__clone1--defaultArea"));

    private final Hyperlink manageSolutionQuotationsHyperlink = new Hyperlink(By.id("__tile31"));

    public void switchToTab(String tabName) {
        Wait.functionPassed(() -> groupTabContainer.switchToTab(tabName));

    }

    public void clickManageSolutionQuotations(){
        manageSolutionQuotationsHyperlink.click();
    }
}
