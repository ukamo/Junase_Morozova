package web.screens.screenProjectMorozova;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Label;

public class OnlinerExampleScreen {
    private final Label onlinerTitleLable = new Label(By.xpath("//img[@class='onliner_logo']"));

    private final Button catalogButton = new Button(By.xpath("//span[@class=\"b-main-navigation__text\" and contains(text(),'Каталог')]"));
    public boolean getScreenTitle() {
        return onlinerTitleLable.isDisplayed();
    }

    public void clickOnCatalog() {
        catalogButton.click();
    }
}
