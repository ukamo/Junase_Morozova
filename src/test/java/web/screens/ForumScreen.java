package web.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.component.Input;
import web.component.Table;

public class ForumScreen {
    public static WebDriver driver;
    //private static final Table forumTable = new Table(By.xpath("//ul[contains(@class,'b-messages-thread')]//li[1]//div[@class='b-mtauthor-i']/div[@class='ava']/table" ));
    private static final String forumTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@class='b-mtauthor-i']/div[@class='ava']/table";

    //private static final String idByTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@data-user-id]";
    private static final String idByTable = "//ul[contains(@class,'b-messages-thread')]//li[%s]//div[@class='b-mta-card']/table";

    public Table getTableIdByNumber(int number) {
        return new Table(By.xpath(String.format(idByTable, number)));
    }
    public String getIdByNumber(int number) {
        return getTableIdByNumber(number).getRowOnliner(1).getCellOnliner(1).getElementP().getText();
        //return new Input(By.xpath(String.format(idByTable, number))).getText();
    }

    public Table getTableByNumber(int number) {
        return new Table(By.xpath(String.format(forumTable, number)));
    }
    public void navigateToMessage(int numberOfTopic){
        getTableByNumber(numberOfTopic).getRowOnliner(numberOfTopic-1).getCellOnliner(numberOfTopic-1).getHyperlink().click();
    }
}
