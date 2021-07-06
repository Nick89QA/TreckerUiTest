package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        Selenide.open("https://stage.hub.crtweb.ru/tracker ");// https://hub.crtweb.ru/tracker
    }

    @After
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.closeWindow();
    }
}
