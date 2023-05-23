package web.screens.screenProjectMorozova;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import web.component.Button;
import web.component.Hyperlink;
import web.component.Label;

public class OnlinerNavigation {

    private final Label onlinerTitleLable = new Label(By.xpath("//img[@class='onliner_logo']"));
    private final Label catalogTitleLable = new Label(By.xpath("//div[@class = 'catalog-navigation catalog-navigation_opened']"));
    private final Label sectionItemCatalog = new Label(By.xpath("//div[contains(@class,'catalog-navigation-list__aside_active')]"));

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
    }

    public boolean getsCatalogTitle() {
        return catalogTitleLable.isDisplayed();
    }

    public void clickCatalogClassifier(String item) {
        String xpath = "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '" + item + "')]";
        Button button = new Button(By.xpath(xpath));
        button.click();
    }

    public boolean getCatalogClassifier(String item) {
        String xpath = "//li[contains(@class, 'catalog-navigation-classifier__item_active')]//span[contains(text(),'" + item + "')]";
        Label label = new Label(By.xpath(xpath));
        return label.isDisplayed();
    }

    public void clickTextSectionItemCatalog(String sectionItem) {
        String sectionItemXpath = "//div[contains(@class,'aside-item')]//div[contains(text(),'" + sectionItem + "')]";
        Hyperlink hyperLinkSection = new Hyperlink(By.xpath(sectionItemXpath));
        hyperLinkSection.click();
    }

    public void getSectionItemCatalog() {
       sectionItemCatalog.isDisplayed();
    }

    public void clickOnProductLink(String product) {
        String productXpath = "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '" + product + "')]";
        Hyperlink hyperLinkSection = new Hyperlink(By.xpath(productXpath));
        hyperLinkSection.click();
    }

    public boolean getProductLink(String product) {
        String xpath = "//h1[contains(@class, 'header_title') and contains(text(), '" + product + "')]";
        Label label = new Label(By.xpath(xpath));
        return label.isDisplayed();
    }

    public void clickOnItemOffers(String item) {
        String xpath = "//div[contains(@class,'schema-product__group')]//a[contains(@title,'" + item + "')]";
        Button button = new Button(By.xpath(xpath));
        button.click();

    }

    public boolean getProductItemOffers(String item) {
        String xpath = "//h1[contains(@class,'catalog-masthead__title') and contains(text(),'" + item + "')]";
        Label label = new Label(By.xpath(xpath));
        return label.isDisplayed();
    }
}
