package web.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.component.Table;

public class ForumScreen {
    private static final String forumTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@class='b-mtauthor-i']/div[@class='ava']/table";
    private static final String idByTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@class='b-mta-card']/table";

    public Table getTableIdByNumber(int number) {
        return new Table(By.xpath(String.format(idByTable, number)));
    }

    public String getIdByNumber(int number) {
        return getTableIdByNumber(number).getRowOnliner(1).getCellOnliner(1).getElementP().getText();
    }

    public Table getTableByNumber(int number) {
        return new Table(By.xpath(String.format(forumTable, number)));
    }

    public void navigateToMessage(int numberOfTopic) {
        getTableByNumber(numberOfTopic).getRowOnliner(numberOfTopic - 1).getCellOnliner(numberOfTopic - 1).getHyperlink().click();
    }
}
