package untils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs","untils"},// обязательно  hooks,testRunner должны быть в папке untils
        tags = "@All"//аннотация по которому запускается тест с консоли командой mvn clean test
)

public class TestRunner extends AbstractTestNGCucumberTests {

}