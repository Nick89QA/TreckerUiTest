package untils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@TrackerTest"//аннотация по которому запускается тест
)

@RunWith(Cucumber.class)
public class TestRunner {

}