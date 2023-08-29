package gracehill.screens;

import fiori.component.Button;
import gracehill.component.Input;
import gracehill.component.SideMenu;
import gracehill.component.TabContainer;
import gracehill.component.Table;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VisionLMSScreen {

    private static final String NEW_REPO_ITEM_XPATH = "//button[contains(@class,'MuiButton-root')and text() = '%s']";

    private final SideMenu navBar = new SideMenu(By.className("css-10rj7tz"));

    private final Table repoTable = new Table(By.className("css-zbq2oo"));

    private final TabContainer tabContainer = new TabContainer(By.xpath("//div[contains(@class,'css-1a6buty')]"));

    private final TabContainer containerNewRepo = new TabContainer(By.className("MuiContainer-root"));

    private final Button newButton = new Button(By.className("css-wyt6e4"));

    private final Input nameInput = new Input(By.xpath("//label[text()='Name']//following::input[1]"));

    private final Input fileInput = new Input(By.cssSelector("input[type=file]"));

    public void navigateToMenuItem(String menuItemName) {
        navBar.navigateToMenuItem(menuItemName).click();
    }

    public String getActiveMenuItem() {
        return navBar.getMenuItem();
    }

    public String getActiveTab() {
        return tabContainer.getHeaderTab().getText();
    }

    public boolean isTableDisplayed() {
        return repoTable.isDisplayed();
    }

    public void clickHyperlinkByNameInTableColumn(String hyperlinkValue, String columnName) {
        //repoTable.getColumn(columnName).getRow(hyperlinkValue).getCell(columnName).getElement().click();
        repoTable.getColumn(columnName).getRowN(hyperlinkValue, columnName).getCell(columnName).getElement().click();
    }

    public void clickNewButton() {
        newButton.click();
    }

    public boolean isContainerNewRepoDisplayed() {
        return containerNewRepo.isDisplayed();
    }

    public void clickByButtonName(String buttonName) {
        new Button(By.xpath(String.format(NEW_REPO_ITEM_XPATH, buttonName))).click();
    }

    public void uploadFileOnContainer(String filePath) {
        fileInput.sendKeys(filePath);
    }

    private String getToday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        return format1.format(cal.getTime());
    }

    public void addTodayInNameInput() {
        String addText = getToday();
        nameInput.addText(addText);
    }

    public String getTextFromNameInput() {
        return nameInput.getValue();
    }
}
