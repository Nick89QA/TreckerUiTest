package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "utils"},// обязательно  hooks,testRunner должны быть в папке utils
        tags = "@test"
)

public class TestRunner extends AbstractTestNGCucumberTests {


}