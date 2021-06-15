package untils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@TrackerTest"//аннотация
)

@RunWith(Cucumber.class)
public class TestRunner {

}