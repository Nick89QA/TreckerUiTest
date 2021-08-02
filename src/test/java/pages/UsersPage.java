package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UsersPage {
    private final SelenideElement inputSearch = $("input[type='search']");//клик на поле поиск
    private final SelenideElement pageUser = $x("//span[text()='Пользователи']");//клик на страницу пользователи
    private final SelenideElement verifySurname = $x("//div[text()='Абдуллаев А.']");//проверка поиска фамилии
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню

    public void setSearchField(String text) {
        inputSearch.shouldBe(Condition.enabled);
        inputSearch.setValue(text);
    }

    public void verifySearch(String text) {
        Selenide.$x(String.format("//div[contains(text(),'%s')]", text)).shouldBe(Condition.enabled);
    }

    public void searchSurName(String surname) {
        inputSearch
                .shouldBe(Condition.enabled).setValue(surname);
    }

    public void verifyResult() {
        verifySurname
                .shouldBe(Condition.appear);
    }

    public void clickBurgerMenu() {
        burgerMenu
                .should(Condition.enabled).click();
    }

    public void clickPageUser() {
        pageUser
                .should(Condition.enabled).click();
    }
}