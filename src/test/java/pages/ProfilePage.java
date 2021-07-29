package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

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
                .should(Condition.enabled)
                .click();
    }

    public void clickInputEmail(String email) {
        inputEmail
                .should(Condition.enabled).setValue(email);
    }

    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled)
                .click();
    }
    public void selectInputFormatDate(String date) {
        inputFormatDate
                .should(Condition.enabled).setValue(date);
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
            .should(Condition.enabled)
            .click();
    }

    public void checkMessageNotificationSuccess() {
    messageNotificationsSuccess
            .should(Condition.visible);

    }
}

