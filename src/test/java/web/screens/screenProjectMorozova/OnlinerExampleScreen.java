package web.screens.screenProjectMorozova;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.component.Button;
import web.component.Hyperlink;
import web.component.Label;

import java.sql.Driver;

public class OnlinerExampleScreen {
    private final Label onlinerTitleLable = new Label(By.xpath("//img[@class='onliner_logo']"));

    //private final Button catalogButton = new Button("//span[@class=\"b-main-navigation__text\" and contains(text(),'Каталог')]")
    public void navigateToOnlinerPage() {
        WebDriverManager.currentSession().getWebDriver().navigate();

    }
    public boolean getsScreenTitle() {
        return onlinerTitleLable.isDisplayed();
    }

    public void clicksOnCatalog(String str) {
        String xpathSection = "//span[@class=\"b-main-navigation__text\" and contains(text(),'" + str + "')]";
        Hyperlink hyperLinkSection = new Hyperlink(By.xpath(xpathSection));
        hyperLinkSection.click();
        //Button catalogButton = new Button(By.xpath(str));
        //catalogButton.click();
    }
}
