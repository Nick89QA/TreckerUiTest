package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Enabled;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UsersPage {

    private final SelenideElement  searchField = $("input[type='search']");//клик на поле поиск


    public void setSearchField(String text) {
        searchField.shouldBe(Condition.enabled).clear();
        searchField.setValue(text);
    }

    public void verifySearch(String text){
        Selenide.$x(String.format("//div[contains(text(),'%s')]",text)).shouldBe(Condition.enabled);
    }
}