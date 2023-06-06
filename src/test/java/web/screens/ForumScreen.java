package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.component.Input;
import web.component.Label;
import web.component.Table;
import web.util.Wait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForumScreen {
    private static final String forumTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@class='b-mtauthor-i']/div[@class='ava']/table";
    private static final String xpathById = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@data-user-id]";
    private static final Label labelByIdInProfile = new Label(By.xpath("//div[contains(@class,'profile-header__details-item')]"));

    public String getIdByNumber(int number) {
        Input inputId = new Input(By.xpath(String.format(xpathById, number)));
        return inputId.getElement().getAttribute("data-user-id");
    }

    public Table getTableByNumber(int number) {
        return new Table(By.xpath(String.format(forumTable, number)));
    }

    public void navigateToMessage(int numberOfTopic) {
        getTableByNumber(numberOfTopic).getRowOnliner(numberOfTopic - 1).getCellOnliner(numberOfTopic - 1).getHyperlink().click();
    }

    public String assertProfile() {
        String labelByIdFullText = labelByIdInProfile.getText();
        Pattern pattern = Pattern.compile(".*(ID: (\\d+))");
        Matcher m = pattern.matcher(labelByIdFullText);
        m.find();
        return m.group(2);
    }

    public boolean assertFieldsExist(String section) {
        List<WebElement> items = WebDriverManager.currentSession().getWebDriver().findElements(By.xpath("//div[contains(@class,'profile-form__label-title_font-weight_normal')]"));
        for (WebElement item : items) {
            if (item.getText().equals(section)) {
                return true;
            }
        }
        return false;
    }

}
