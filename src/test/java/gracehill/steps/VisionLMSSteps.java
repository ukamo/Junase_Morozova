package gracehill.steps;

import eu.ibagroup.junase.model.util.Assert;
import eu.ibagroup.junase.web.test.WebDriverManager;
import gracehill.screens.VisionLMSScreen;
import gracehill.utils.PropertiesReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class VisionLMSSteps {

    private final VisionLMSScreen visionLMSScreen = new VisionLMSScreen();

    private static final String FILE_PATH = "FilePath.json";

    private static String nameOfRepoItem;

    @Then("^I navigate to menu item (.*) on screen (Vision LMS) in application (Gracehill)$")
    public void navigateTo(String menuItemName, String screen, String app) {
        visionLMSScreen.navigateToMenuItem(menuItemName);
    }

    @Then("^I assert I am on tab (.*) on screen (Vision LMS) in application (Gracehill)$")
    public void assertTab(String tabName, String screen, String app) {
        if (tabName.equals("REPOSITORY")) {
            Assert.assertEquals(tabName, visionLMSScreen::getActiveMenuItem);
        } else if (tabName.equals("IBA_VL")) {
            Assert.assertEquals(tabName, visionLMSScreen::getActiveTab);
        } else if (tabName.equals("Name of repo item")) {
            //WebDriverManager.currentSession().getWebDriverWait().wait(50000);
            //  .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'css-2bp9od')]")));
            Assert.assertEquals(nameOfRepoItem, visionLMSScreen::getActiveTab);
        }
    }

    @Then("^I assert I am on container (.*) on screen (Vision LMS) in application (Gracehill)$")
    public void assertContainer(String containerName, String screen, String app) {
        Assert.assertTrue(visionLMSScreen::isContainerNewRepoDisplayed);
    }

    @Then("^I assert table is displayed on tab (REPOSITORY) on screen (Vision LMS) in application (Gracehill)$")
    public void assertSelectTableIsDisplayed(String tabName, String screen, String app) {
        Assert.assertTrue(visionLMSScreen::isTableDisplayed);
    }

    @When("^I click hyperlink (.*) \"(.*)\" in the table on tab (REPOSITORY) on screen (Vision LMS) in application (Gracehill)$")
    public void clickHyperlinkByNameInTableColumn(String columnName, String hyperlinkValue, String tabName, String screen, String app) {
        visionLMSScreen.clickHyperlinkByNameInTableColumn(hyperlinkValue, columnName);
    }

    @When("^I click button (New) on tab (IBA_VL) on screen (Vision LMS) in application (Gracehill)$")
    public void clickNewButton(String buttonName, String tabName, String screen, String app) {
        visionLMSScreen.clickNewButton();
    }

    @When("^I upload file on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void uploadFileOnContainer(String containerName, String screen, String app) throws IOException, ParseException {
        String filePath = PropertiesReader.parseJSONFile(FILE_PATH, "filepath");
        visionLMSScreen.uploadFileOnContainer(filePath);
    }

    @When("^I upload (Quiz) file on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void uploadQuizFileOnContainer(String typeFile, String containerName, String screen, String app) throws IOException, ParseException {
        String filePath = PropertiesReader.parseJSONFile(FILE_PATH, "filepathQuiz");
        visionLMSScreen.uploadFileOnContainer(filePath);
    }

    @Then("^I click button (Submit) on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void clickButtonOnContainer(String buttonName, String containerName, String screen, String app) throws InterruptedException {
        visionLMSScreen.clickByButtonName(buttonName);
        (new WebDriverWait(WebDriverManager.currentSession().getWebDriver(), 60))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'css-2bp9od')]")));
        System.out.println(nameOfRepoItem);
    }

    @Then("^I add (Name) today's date on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void addTodayDateInNameField(String fieldName, String containerName, String screen, String app) {
        visionLMSScreen.addTodayInNameInput();
    }

    @Then("^I store (Name) of repo item on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void storeNameByRepoItem(String fieldName, String containerName, String screen, String app) {
        nameOfRepoItem = visionLMSScreen.getTextFromNameInput();
    }

    @When("^I check checkbox (Quiz or Survey upload) on container (New Repo Item) on screen (Vision LMS) in application (Gracehill)$")
    public void checkCheckbox(String labelName, String containerName, String screen, String app) {
        visionLMSScreen.checCheckboxByLabel(labelName);
    }
}
