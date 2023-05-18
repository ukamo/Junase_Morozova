package web.screens;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.model.util.FileUtil;
import web.component.Button;
import web.component.Input;
import web.util.Wait;
import eu.ibagroup.junase.web.test.WebDriverManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginScreen {

    private final Input usernameInput = new Input(By.name("username"));

    private final Input passwordInput = new Input(By.name("password"));

    private final Button signInButton = new Button(By.xpath("//button[@type='submit']"));

    private final Button chooseLanguageDropdownButton = new Button(By.xpath("//button[@class='language-switcher' or @aria-label='LanguageTrigger']"));

    public void loginToAppFromFileWithUser(String username, String filename) throws IOException, ParseException {
        File importFile = FileUtil.createFileFromResource("testdata/" + filename);
        Object object = new JSONParser().parse(new FileReader(importFile));
        JSONObject jsonObject = (JSONObject) object;
        String password = (String) jsonObject.get(username);
        Wait.functionPassed(() -> {
            chooseLanguageOnLogInPage("en");
            usernameInput.setText(username);
            passwordInput.setText(password);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            signInButton.click();
        });
    }

    private void chooseLanguageOnLogInPage(String value) {
        chooseLanguageDropdownButton.click();
        Wait.functionPassed(() -> {
            WebElement listOfElements = WebDriverManager.currentSession().getWebDriver().findElement(By.xpath("//div[@id='options-list']"));
            for (WebElement element : listOfElements.findElements(By.tagName("div"))) {
                if (element.getAttribute("data-lang").equals(value)) {
                    element.click();
                    return;
                }
            }
            throw new IllegalStateException("Cannot locate element with text [" + value + "]");
        });
    }
}