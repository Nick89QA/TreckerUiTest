package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Cleanup;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContractorPage {
    private final SelenideElement menuButtonContractor = $x("//span[text()='Подрядчики']");//кнопка меню подрядчики
    private final SelenideElement buttonCreateContract = $x("//div[@role='button']");//кнопка создать подряд
    private final SelenideElement inputFullTittle = $x("//input[@name='fullName']");//поле полное название
    private final SelenideElement inputShortName = $x("//input[@name='shortName']");//поле короткое название
    private final SelenideElement createButton = $x("//span[text()='Создать подрядчика']");//кнопка создать подрядчика
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
        checkSuccessContract.shouldBe(Condition.appear);
    }

    public void reviewContractPage() {
        burgerMenu.shouldBe(Condition.enabled).click();//клик на бургер меню
        menuButtonContractor.shouldBe(Condition.enabled).click();//клик на страницу подрядчики
    }

    public void checkContractPage() {//метод проверки на странице"Список подрядчиков"
        checkPageContract.shouldBe(Condition.appear);
    }

    public void createContract(Map<String, String> map) {//метод создвет подряд
        burgerMenu.shouldBe(Condition.enabled).click();
        menuButtonContractor.shouldBe(Condition.enabled).click();
        buttonCreateContract.shouldBe(Condition.enabled).click();
        inputFullTittle.shouldBe(Condition.enabled).setValue(map.get("Полное название")).click();
        inputShortName.shouldBe(Condition.enabled).setValue(map.get("Короткое название")).click();
        createButton.shouldBe(Condition.enabled).click();
    }

    public void userDeleteContract() {
        burgerMenu.shouldBe(Condition.enabled).click();
        menuButtonContractor.shouldBe(Condition.enabled).click();//клик на страницу подрядчики
        $(inputDeleteContract).scrollIntoView(true);
        inputDeleteContract.shouldBe(Condition.enabled).click();//клик на поле с подрядом
        buttonBasket.shouldBe(Condition.enabled).click();//клик на корзину
        buttonDelete.shouldBe(Condition.enabled).click();

    }

    public void verifyDeleteContract() {
        verifyDelContract.shouldBe(Condition.enabled);
    }

    public void userEditContract(Map<String, String> map) {//редактирование информации о подряде
        burgerMenu.shouldBe(Condition.enabled).click();//бургер меню
        menuButtonContractor.shouldBe(Condition.enabled).click();//страница подрядчики в меню
        inputContract.shouldBe(Condition.enabled).click();//поле конкретного подрядчика
        buttonEditContract.shouldBe(Condition.enabled).click();//клик на карандаш
        inputName.shouldBe(Condition.enabled).setValue(map.get("Добавление информации"));
        buttonSave.shouldBe(Condition.enabled).click();
    }

    public void verifyEditContract() {
        verifySuccessContract.shouldBe(Condition.enabled);
    }
}