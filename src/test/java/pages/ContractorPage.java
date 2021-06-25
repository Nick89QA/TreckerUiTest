package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class ContractorPage {
    private final SelenideElement menuButtonContractor = $x("//span[text()='Подрядчики']");//кнопка меню подрядчики
    private final SelenideElement buttonCreateContract = $x("//div[@role='button']");//кнопка создать подряд
    private final SelenideElement inputFullTittle = $x("//input[@name='fullName']");//поле полное название
    private final SelenideElement inputShortName = $x("//input[@name='shortName']");//поле короткое название
    private final SelenideElement createButton = $x("//span[text()='Создать подрядчика']");//кнопка создать подрядчика
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement checkSuccessContract = $x("//div[text()='Подрядчик создан']");
    private final SelenideElement checkPageContract = $x("//div[h1='Список подрядчиков']");//проверка на странице подряд "Список подрядчиков"

    public void createContract(Map<String,String> map) {
        burgerMenu.shouldBe(Condition.enabled).click();//клик на бургер меню
        menuButtonContractor.shouldBe(Condition.enabled).click();//клик на страницу подрядчики
        buttonCreateContract.shouldBe(Condition.enabled).click();//клик на плюсик создать подряд
        inputFullTittle.shouldBe(Condition.enabled).setValue(map.get("Полное название"));//вводим значения
        inputShortName.shouldBe(Condition.enabled).setValue(map.get("Короткое название"));//вводим значения
        createButton.shouldBe(Condition.enabled).click();//клик на кнопку создать проект
    }

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

}
