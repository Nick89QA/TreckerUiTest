package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.files.DownloadActions.click;

public class ProfilePage {
    private final SelenideElement buttonIcon = $x("//button[@id='accountIdButton']");
    private final SelenideElement buttonProfile = $x("//a[text()='Профиль']");
    private final SelenideElement buttonEdit = $x("//span[text()='Редактировать']");
    private final SelenideElement inputEmail = $x("//input[@name='email']");
    private final SelenideElement buttonSave = $x("//span[text()='Сохранить']");
    private final SelenideElement inputFormatDate = $x("(//div[@aria-haspopup='listbox'])[1]");
    private final SelenideElement buttonCalendar = $x("//span[text()='Сегодня']");
    private final SelenideElement buttonLastMonth = $x("//span[text()='Прошлый месяц']");
    private final SelenideElement verifyLastMonth = $x("//h3[text()='Время пользователя по проектам']");
    private final SelenideElement buttonClickForExitFromCalendar = $x("//h6[text()='Creative Test Platform']");
    private final SelenideElement checkRoleOnPage = $x("//div[text()='Роль']");
    private final SelenideElement messageNotificationsSuccess = $x("//div[text()='Успешно']");
    private final SelenideElement inputFormatTime = $x("//div[@id='mui-component-select-timeLocale']");
    private final SelenideElement inputName = $x("//input[@name='firstName']");
    private final SelenideElement inputLastName = $x("//input[@name='lastName']");

    public void clickIconButton() {
        buttonIcon
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonProfile() {
        buttonProfile
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonEdit() {
        buttonEdit
                .scrollIntoView(true)
                .should(Condition.enabled)
                .click();
    }

    public void editInputEmail(String email) {
        inputEmail
                .should(Condition.enabled).setValue(email)
                .click();
    }

    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled)
                .click();
    }

    public void selectInputFormatDate(String formatDate) {
        inputFormatDate
                .should(Condition.enabled);
    }

    public void clickButtonCalendar() {
        buttonCalendar
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonLastMonth() {
        buttonLastMonth
                .should(Condition.enabled)
                .click();
    }

    public void checkVerifyLastMonth() {
        verifyLastMonth
                .should(Condition.visible);
    }

    public void clickButtonClickForExitFromCalendar() {
        buttonClickForExitFromCalendar
                .should(Condition.enabled)
                .click();
    }

    public void verifyCheckRoleOnPage() {
        checkRoleOnPage
                .should(Condition.enabled);
    }

    public void checkMessageNotificationSuccess() {
        messageNotificationsSuccess
                .should(Condition.visible);

    }

    public void selectInputFormatTime(String formatTime) {
        inputFormatTime
                .should(Condition.enabled)
                .click();
    }

    public void setInputName(String name) {
        inputName
                .should(Condition.enabled)
        .setValue(name);
    }

    public void setInputLastName(String lastName) {
        inputLastName
                .should(Condition.enabled)
                .setValue(lastName);
    }
}

