package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/TrackerTest.feature"},
        glue = {"stepdefs", "utils"},
        tags = "@positive or @negative",
        plugin = {"pretty"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}