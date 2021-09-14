package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {
    private static final Logger log = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        this.scenario = scenario;
        log.debug("\n----\n" + scenario.getName() + "\n----");
        //скрипт для запуска докер контейнера
//        URL url = new URL("http://localhost:4444");
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        RemoteWebDriver driver = new RemoteWebDriver(url,dc);
//        driver.get("https://stage.hub.crtweb.ru/tracker ");
//        System.out.println("Title of page:" +driver.getTitle());
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
