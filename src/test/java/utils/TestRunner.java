package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs", "utils"},// обязательно  hooks,testRunner должны быть в папке untils
        tags = "@All"//аннотация по которому запускается тест с консоли командой mvn clean test
)

public class TestRunner extends AbstractTestNGCucumberTests {


}