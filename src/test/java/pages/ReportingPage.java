package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ReportingPage {
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement clickReportPage = $x("//span[text()='Отчетность']");// клик на стран отчетность
    private final SelenideElement clickAtCalendar = $x("//span[text()='Сегодня']");//клик на календарь
    private final SelenideElement clickLastMonth = $x("//span[text()='Прошлый месяц']");//клик на параметр
    private final SelenideElement checkVerifyLastMonth = $x("//span[text()='Прошлый месяц']");


    public void userOnReportPage() {
        burgerMenu.shouldBe(Condition.enabled).click();
        clickReportPage.shouldBe(Condition.enabled).click();
        clickAtCalendar.shouldBe(Condition.enabled).click();
        clickLastMonth.shouldBe(Condition.enabled).click();
    }

    public void checkWrightResult() {
        checkVerifyLastMonth.shouldBe(Condition.enabled).click();
    }
}
