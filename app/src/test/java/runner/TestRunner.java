package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = {"steps"},              // <- Hooks.java debe estar dentro de "steps"
    plugin = {"pretty","summary","html:build/reports/cucumber.html"},
    monochrome = true
)
public class TestRunner {

}
