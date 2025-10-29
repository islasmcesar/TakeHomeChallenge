package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    @Before
    public void beforeScenario() {
        DriverManager.start();
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        WebDriver driver = DriverManager.get();

        try {
        byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(png, "image/png", "step-screenshot");
        } catch (Exception e) {
        // No interrumpas el test si falla la captura
        System.err.println("[WARN] Screenshot failed: " + e.getMessage());
        }
    }

    @After
    public void afterScenario() {
        DriverManager.stop();
    }

}

