package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "utils"},
        tags = "@test",
        plugin = {"pretty"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}