package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UsersPage {
    private final SelenideElement inputSearch = $("input[type='search']");//клик на поле поиск
    private final SelenideElement pageUser = $x("//span[text()='Пользователи']");//клик на страницу пользователи
    private final SelenideElement surname = $x("//div[text()='Абдуллаев А.']");//проверка поиска фамилии
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement MessageAbsence = $x("//div[contains(text(),'Таких пользователей')]");
    private final SelenideElement paginationPageOne = $x("//button[@aria-label='page 1']");//клик на страницу 1
    private final SelenideElement checkPagination = $x("//div[@role='progressbar']");//лоадер при нажатии на страницу в пагинации
    private final SelenideElement buttonPencil = $x("//div[@role='button']/parent::div");//клик на карандаш
    private final SelenideElement dropDownList = $x("//div[@aria-haspopup='listbox']/parent::div");
    private final SelenideElement roleAdministrator = $x("//li[text()='Администратор']");
    private final SelenideElement roleGeneralManager = $x("//li[text()='Главный менеджер']");
    private final SelenideElement roleManager = $x("//li[text()='Менеджер']");
    private final SelenideElement roleDeveloper = $x("//li[text()='Разработчик']");
    private final SelenideElement buttonSave = $x("(//div[@role='button'])[2]");
    private final SelenideElement messageSuccess = $x("//div[text()='Успешно']");

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
        surname
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

    public void verifyMessageAbsence() {
        MessageAbsence
                .should(Condition.appear);
    }

    public void clickPaginationPageOne() {
        paginationPageOne
                .should(Condition.enabled)
                .click();
    }

    public void verifyCheckPagination() {
        checkPagination
                .should(Condition.appear);

    }

    public void clickSurname() {
        surname
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonPencil() {
        buttonPencil
                .should(Condition.enabled)
                .click();
    }

    public void clickDropDownList() {
        dropDownList
                .should(Condition.enabled)
                .click();
    }

    public void clickRoleAdministrator() {
        roleAdministrator
                .should(Condition.enabled)
                .click();
    }

    public void clickRoleGeneralManager() {
        roleGeneralManager
                .should(Condition.enabled)
                .click();

    }

    public void clickRoleManager() {
        roleManager
                .should(Condition.enabled)
                .click();
    }

    public void clickRoleDeveloper() {
        roleDeveloper
                .should(Condition.enabled)
                .click();
    }


    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled)
                .pressEnter();
    }

    public void checkMessageSuccess() {
        messageSuccess
                .should(Condition.appear);
    }


}
