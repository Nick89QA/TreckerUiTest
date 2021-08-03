package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;


public class WebUtils {

    public static void switchWindow(int num) {
        Selenide.switchTo()
                .window(num);
    }

    public static void clearField(SelenideElement element) {
        element.shouldBe(Condition.enabled);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        element.shouldBe(Condition.empty);
        ;

    }

}
