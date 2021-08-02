package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ReportingPage {
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement pageReport = $x("//span[text()='Отчетность']");// клик на стран отчетность
    private final SelenideElement buttonCalendar = $x("//span[text()='Сегодня']");//клик на календарь
    private final SelenideElement buttonLastMonth = $x("//span[text()='Прошлый месяц']");//клик на параметр
    private final SelenideElement checkVerifyLastMonth = $x("//span[text()='Прошлый месяц']");




    public void checkRightResult() {
        checkVerifyLastMonth
                .shouldBe(Condition.enabled).click();
    }

    public void clickBurgerMenu() {
        burgerMenu
                .should(Condition.enabled).click();
    }

    public void clickPageReport() {
        pageReport
                .should(Condition.enabled).click();
    }

    public void clickButtonCalendar() {
        buttonCalendar
                .should(Condition.enabled).click();
    }

    public void clickButtonLastMonth() {
        buttonLastMonth
                .should(Condition.enabled).click();
    }
}
