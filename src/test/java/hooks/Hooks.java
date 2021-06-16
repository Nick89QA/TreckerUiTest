package hooks;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        Selenide.clearBrowserCookies();
        Selenide.open("https://hub.crtweb.ru/tracker");
    }

}
