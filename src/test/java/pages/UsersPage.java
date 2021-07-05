package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Enabled;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UsersPage {
    private final SelenideElement searchField = $("input[type='search']");//клик на поле поиск
    private final SelenideElement clickOnUserPage = $x("//span[text()='Пользователи']");//клик на страницу пользователи
    private final SelenideElement verifySurname = $x("//div[text()='Абдуллаев А.']");//проверка поиска фамилии
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню


    public void setSearchField(String text) {
        searchField.shouldBe(Condition.enabled).clear();
        searchField.setValue(text);
    }

    public void verifySearch(String text) {
        Selenide.$x(String.format("//div[contains(text(),'%s')]", text)).shouldBe(Condition.enabled);
    }


    public void searchSurname(Map<String, String> map) {
        burgerMenu.shouldBe(Condition.enabled).click();
        clickOnUserPage.shouldBe(Condition.enabled).click();
        searchField.shouldBe(Condition.enabled).setValue(map.get("Фамилия"));
    }

    public void verifyResult() {
        verifySurname.shouldBe(Condition.appear);
    }

}