package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ContractorPage {
    private final SelenideElement buttonMenuContract = $x("//span[text()='Подрядчики']");//кнопка меню подрядчики
    private final SelenideElement buttonCreateContract = $x("//div[@role='button']");//кнопка создать подряд
    private final SelenideElement inputFullTittle = $x("//input[@name='fullName']");//поле полное название
    private final SelenideElement inputShortName = $x("//input[@name='shortName']");//поле короткое название
    private final SelenideElement buttonCreate = $x("//span[text()='Создать подрядчика']");//кнопка создать подрядчика
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement checkSuccessContract = $x("//div[text()='Успешно']");//проверка на успешное создание/или удаление
    private final SelenideElement checkPageContract = $x("//div[h1='Список подрядчиков']");//проверка на странице подряд "Список подрядчиков"
    private final SelenideElement inputDeleteContract = $x("//div[text()='Разработка планов']");//кнопка привязана к названию подряда
    private final SelenideElement verifyDelContract = $x("//div[text()='Подрядчик удален']");//проверка удаления подряда
    private final SelenideElement buttonBasket = $x("(//span[@class='MuiIconButton-label'])[5]");//кнопка корзина
    private final SelenideElement buttonDelete = $x("//span[text()='Удалить']");//кнопка удалить
    private final SelenideElement inputContract = $x("//div[text()='АО НПФ Сбербанка ff ']");//клик на поле НПФ Сбербанк
    private final SelenideElement buttonEditContract = $x("(//div[@role='button'])[1]");//клик на карандаш
    private final SelenideElement inputName = $x("//input[@name='shortName']");//клик на поле
    private final SelenideElement buttonSave = $x("(//span[@class='MuiIconButton-label'])[6]");//кнопка сохранения
    private final SelenideElement verifySuccessContract = $x("//div[text()='Подрядчик сохранен']");//проверка на сохранения


    public void checkNewContract() {
        checkSuccessContract
                .shouldBe(Condition.appear);
    }

    public void checkContractPage() {//метод проверки на странице"Список подрядчиков"
        checkPageContract
                .shouldBe(Condition.appear);
    }

    public void clickButtonCreate() {//метод создвет подряд
        buttonCreate
                .shouldBe(Condition.enabled).click();
    }

    public void verifyDeleteContract() {
        verifyDelContract
                .shouldBe(Condition.enabled);
    }

    public void verifyEditContract() {
        verifySuccessContract
                .shouldBe(Condition.enabled);
    }

    public void clickBurgerMenu() {
        burgerMenu
                .shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void clickButtonMenuContract() {
        buttonMenuContract
                .should(Condition.enabled).click();
    }

    public void clickButtonCreateContract() {
        buttonCreateContract
                .should(Condition.enabled).click();
    }

    public void setInputFullTittle(String tittle) {
        inputFullTittle
                .should(Condition.enabled).setValue(tittle).click();
    }

    public void setInputShortName(String name) {
        inputShortName
                .should(Condition.enabled).setValue(name).click();
    }

    public void scrollInputDeleteContract() {
        inputDeleteContract
                .scrollIntoView(true);
    }

    public void clickInputContract() {
        inputDeleteContract
                .shouldBe(Condition.enabled).click();
    }

    public void clickButtonEditContract() {
        buttonEditContract
                .shouldBe(Condition.enabled).click();
    }

    public void clickButtonBasket() {
        buttonBasket
                .shouldBe(Condition.enabled).click();
    }

    public void clickButtonDelete() {
        buttonDelete
                .shouldBe(Condition.enabled).click();
    }

    public void sendInputName(String input) {
        inputName
                .shouldBe(Condition.enabled).setValue(input);
    }

    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled).click();
    }
}