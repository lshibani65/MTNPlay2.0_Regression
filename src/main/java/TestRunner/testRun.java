package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/",
                glue = "StepDefinition",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty","html:test-output.html"},
                tags = "@test"
        )
class TestRun {
}

