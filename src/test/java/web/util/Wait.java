package web.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eu.ibagroup.junase.model.util.CommonWait;
import eu.ibagroup.junase.web.test.WebDriverManager;

import java.util.concurrent.Callable;

public class Wait extends CommonWait {

    private static final Logger LOG = LoggerFactory.getLogger(CommonWait.class);

    private static WebDriverWait getWebDriverWait() {
        return WebDriverManager.currentSession().getWebDriverWait();
    }

    /**
     * This method must be invoked for any action with return from model.component
     * method. It executes passed logic and in case of any occasional exceptions
     * like block ui or dialog mask or StaleElementReferenceException it repeats
     * the action during webdriver timeout.
     * <p>
     * Examples of invokation this method: <br>
     * functionPassed(element::getText) -- without input params and<br>
     * functionPassed(() -> element.get(text)) with parameters or when there is a
     * chain of methods
     *
     * @param function
     */
    public static void functionPassed(final Runnable function) {

        getWebDriverWait().until(new ExpectedCondition<Boolean>() {
            private RuntimeException exception;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    Wait.invisibilityOfBlockUI();
                    function.run();
                    return true;
                } catch (StaleElementReferenceException | IllegalStateException | NoSuchElementException exception) {
                    this.exception = exception;
                }
                return false;
            }

            @Override
            public String toString() {
                throw exception;
            }
        });
    }

    /**
     * This method must be invoked for any action with return from model.component
     * method. It executes passed logic and in case of any occasional exceptions
     * like block ui or dialog mask or StaleElementReferenceException it repeats
     * the action during webdriver timeout.
     * <p>
     * Examples of invokation this method: <br>
     * functionPassed(element::getText) -- without input params and<br>
     * functionPassed(() -> element.get(text)) with parameters or when there is a
     * chain of methods
     *
     * @param function
     */
    public static <T> T functionPassed(final Callable<T> function) {
        return getWebDriverWait().until(new ExpectedCondition<T>() {
            private RuntimeException exception;

            @Override
            public T apply(WebDriver driver) {
                try {
                    Wait.invisibilityOfBlockUI();
                    return function.call();
                } catch (StaleElementReferenceException | IllegalStateException | NoSuchElementException exception) {
                    this.exception = exception;
                } catch (Exception e) {
                    LOG.debug(e.getMessage());
                }
                return null;
            }

            @Override
            public String toString() {
                throw exception;
            }
        });
    }

    public static void invisibilityOfBlockUI() {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.className("")));
    }

    public static void textToBePresentInElement(WebElement element, String text) {
        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void visibilityOfElementLocated(By locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void visibilityOfElement(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void presenceOfElementLocated(By locator) {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void inVisibilityOfElement(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void elementToBeClickable(By locator) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void elementToBeClickable(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void elementToBeRefreshed(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(webElement)));
    }

    public static void frameAvailableAndSwitchToIt(By locator) {
        getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void frameAvailableAndSwitchToIt(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public static void verifyTitle(String title) {
        getWebDriverWait().until(ExpectedConditions.titleIs(title));
    }

    public static void verifyTitleContains(String value) {
        getWebDriverWait().until(ExpectedConditions.titleContains(value));
    }

    public static void attributeContains(WebElement element, String attribute, String value) {
        getWebDriverWait().until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static void waitForLoad() {
        getWebDriverWait().until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete' ? true : false"));
    }
}