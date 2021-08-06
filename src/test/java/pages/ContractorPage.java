package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

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
    private final SelenideElement inputSelectContract = $x("//div[text()='Разработка планов']");//кнопка привязана к названию подряда
    private final SelenideElement verifyDelContract = $x("//div[text()='Подрядчик удален']");//проверка удаления подряда
    private final SelenideElement buttonBasket = $x("(//span[@class='MuiIconButton-label'])[5]");//кнопка корзина
    private final SelenideElement buttonDelete = $x("//span[text()='Удалить']");//кнопка удалить
    private final SelenideElement inputContract = $x("//div[text()='АО НПФ Сбербанка ff ']");//клик на поле НПФ Сбербанк
    private final SelenideElement buttonEditContract = $x("//div[@id='editButton']");//клик на кара
    private final SelenideElement inputName = $x("//input[@name='shortName']");//клик на поле
    private final SelenideElement buttonSave = $x("//div[@id='saveButton']");//кнопка сохранить
    private final SelenideElement verifySuccessContract = $x("//div[text()='Успешно']");//проверка на сохранения

    org.apache.logging.log4j.Logger log = LogManager.getLogger(ContractorPage.class.getName());
    public void checkNewContract() {
        try {
            checkSuccessContract
                    .shouldBe(Condition.appear);
        log.info("Contract create successful");
        }catch (com.codeborne.selenide.ex.ElementNotFound e){
            log.error("Contract creation failed");
            Assert.fail("Fail to create task(Notification did not appear)");
        }

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
                .should(Condition.enabled);
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
        inputSelectContract
                .scrollIntoView(true);
    }

    public void clickInputContract() {
        inputSelectContract
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
                .shouldBe(Condition.enabled);
    }

    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled).click();
    }
}