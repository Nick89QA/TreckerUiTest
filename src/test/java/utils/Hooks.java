package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.invoke.MethodHandles;

public class Hooks {
    private static final Logger log = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        log.debug("\n----\n" + scenario.getName() + "\n----");


        Selenide.open("https://stage.hub.crtweb.ru/tracker ");// https://hub.crtweb.ru/tracker
    }


    @After
    public void tearDown(Scenario scenario) {
        this.scenario = scenario;
        if (scenario.isFailed()) {
            log.error(scenario.getName() + " Failed ");
        } else {
            log.info(scenario.getName() + " Success ");
        }
        Selenide.clearBrowserCookies();
        Selenide.closeWindow();
    }
}
