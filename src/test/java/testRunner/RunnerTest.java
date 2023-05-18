package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        strict = true,
        glue = {"web.steps.stepsProjectMorozova", "web.steps", "desktop.steps", "mobile.steps", "api.steps", "javaApp.steps", "sap.steps", "testRunner"},
        plugin = {"pretty", "html:target/selenium-report", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class RunnerTest {
}