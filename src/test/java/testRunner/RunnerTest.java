package testRunner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@IncludeTags("test")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "web.steps , testRunner"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/report.html, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"),
})
public class RunnerTest {
}