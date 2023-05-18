package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Hyperlink;
import web.component.Input;

public class AutomationProcessDetailsScreen {

    private final Input nameInput = new Input(By.xpath("//input[@name='name']"));

    private final Input groupIdInput = new Input(By.xpath("//input[@name='groupId']"));

    private final Input artifactIdInput = new Input(By.xpath("//input[@name='artifactId']"));

    private final Input versionIdInput = new Input(By.xpath("//input[@name='versionId']"));

    private final Hyperlink backToList = new Hyperlink(By.xpath("//p[text()='Back to list']"));

    private final Button createNewButton = new Button(By.xpath("//button[text()='Create New']"));

    public void setName(String name) {
        nameInput.setText(name);
    }

    public void setGroupId(String value) {
        groupIdInput.setText(value);
    }

    public void setArtifactId(String value) {
        artifactIdInput.setText(value);
    }

    public void setVersionId(String value) {
        versionIdInput.setText(value);
    }

    public void clickBackToList() {
        backToList.click();
    }

    public void clickCreateNew() {
        createNewButton.click();
    }
}