package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;


public class ProfilePage  {
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
    private final SelenideElement inputSurName = $x("//input[@name='surname']");//отчество
    private final SelenideElement nameText = $x("//label[text()='Имя']/span");
    private final SelenideElement lastNameText = $x("//label[text()='Фамилия']/span");
    private final SelenideElement surNameText = $x("//label[text()='Отчество']/span");
    private final SelenideElement mailText = $x("//label[text()='Почта']/span");
    private final SelenideElement formatDateText = $x("//div[text()='Формат даты']/span");
    private final SelenideElement formatTimeText = $x("//div[text()='Формат времени']/span");



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

    public void clickButtonSave() {
        buttonSave
                .scrollIntoView(true)
                .should(Condition.enabled)
                .click();
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

    public void setProfilePageInputs(Map<String, String> map) {
        WebUtils.clearField(inputName);
        inputName
                .shouldBe(Condition.enabled)
                .setValue(map.get("Имя"));
        WebUtils.clearField(inputLastName);
        inputLastName
                .should(Condition.enabled)
                .setValue(map.get("Фамилия"));
        WebUtils.clearField(inputSurName);
        inputSurName
                .shouldBe(Condition.enabled)
                .setValue(map.get("Отчество"));
        WebUtils.clearField(inputEmail);//передаем inputEmail
        inputEmail
                .shouldBe(Condition.enabled)
                .setValue(map.get("Электронная почта"));
        inputFormatDate
                .should(Condition.enabled)
                .click();
        Selenide.$x(String.format("//li[text()='%s']", map.get("Формат даты"))).click();
        inputFormatTime
                .should(Condition.enabled)
                .click();
        Selenide.$x(String.format("//li[text()='%s']", map.get("Формат времени"))).click();
    }

    public Map<String, String> getProfileInfo() {
        //Map<String,String> actualMap = profilePage.getProfileInfo();
       Map<String, String> actualMap = new HashMap<String, String>();
       actualMap.put("Имя",nameText.text());
       actualMap.put("Фамилия",lastNameText.text());
       actualMap.put("Отчество",surNameText.text());
       actualMap.put("Электронная почта",mailText.text());
       actualMap.put("Формат даты",formatDateText.text());
       actualMap.put("Формат времени",formatTimeText.text());
      return actualMap;
    }

}

