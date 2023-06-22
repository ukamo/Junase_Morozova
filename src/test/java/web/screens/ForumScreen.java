package web.screens;

import org.openqa.selenium.By;
import web.component.Hyperlink;

public class ForumScreen {

    private static final String hyperlinkForum = "//div[contains(@class,'forum__title')]/a[contains(text(),'%s')]";

    public void clickHyperlink(String hyperlinkName) {
        new Hyperlink(By.xpath(String.format(hyperlinkForum, hyperlinkName))).click();
    }
}
