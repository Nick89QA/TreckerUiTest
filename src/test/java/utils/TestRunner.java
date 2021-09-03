package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "utils"},// обязательно  hooks,testRunner должны быть в папке utils
        tags = "@All" //аннотация по которому запускается тест с консоли командой mvn clean test
)

public class TestRunner extends AbstractTestNGCucumberTests {


}