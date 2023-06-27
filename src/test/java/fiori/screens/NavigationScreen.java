package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;


public class NavigationScreen {

    public String getScreenTitle() {
        return WebDriverManager.currentSession().getWebDriver().getTitle();
    }
}
