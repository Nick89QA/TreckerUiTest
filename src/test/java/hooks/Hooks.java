package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        Selenide.clearBrowserCookies();
        Selenide.open("https://stage.hub.crtweb.ru/tracker");// https://hub.crtweb.ru/tracker
    }

}
