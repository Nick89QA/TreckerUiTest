package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "utils"},
        tags = "@test or @positive or @negative"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}