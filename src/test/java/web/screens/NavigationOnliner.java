package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import web.component.Hyperlink;

import static web.component.Hyperlink.getDisplayedContentByTitle;

public class NavigationOnliner {
    private static final String SECTION_XPATH = "//ul[contains(@class, 'b-main-navigation')]//span[contains(text(),'%s')]";

    public void navigateToOnlinerPage() {
        WebDriverManager.currentSession().getWebDriver().navigate();
    }

    public void clickOnSection(String section) {
        new Hyperlink(By.xpath(String.format(SECTION_XPATH, section))).click();
    }

    public String getContent() {
        return getDisplayedContentByTitle().getContent();
    }

}


