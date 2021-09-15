package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.core.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;

import static org.apache.tools.ant.taskdefs.Antlib.TAG;


public class WebUtils {

    org.apache.logging.log4j.Logger log = LogManager.getLogger(WebUtils.class.getName());

    public void switchWindow(String title) {
        log.info("Title на странице " + Selenide.title());
        Selenide.switchTo()
                .window(title);
        log.info("Title на странице " + Selenide.title());

    }

    public static void clearField(SelenideElement element) {
        element.shouldBe(Condition.enabled);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.shouldBe(Condition.empty);
        ;

    }

}
