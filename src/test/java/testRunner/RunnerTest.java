package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        strict = true,
        glue = {"web.steps", "testRunner"},
        plugin = {"pretty", "html:target/selenium-report", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class RunnerTest {
}