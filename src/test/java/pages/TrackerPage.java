package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TrackerPage {
    private final SelenideElement nameInput = $("input[name='title']");
    private final SelenideElement inputProject = $("input[name='project']");
    private final SelenideElement startTime = $("input[name='start']");
    private final SelenideElement endTime = $("input[name='end']");
    private final SelenideElement description = $("input[name='description']");
    private final SelenideElement inputLink = $("input[name='link']");
    private final SelenideElement addTimeButton = $x("(//span[text()='Добавить время'])[2]");
    private final SelenideElement successMessage =$x("//div[@class='MuiAlert-message'][text()='Временной промежуток добавлен']");
    private final SelenideElement projectName = $x("//input[@name='project']");//клик на элемент
    private final SelenideElement noOptions = $x("//div[text()='No options']");
    private final SelenideElement burgerMenu = $x("//button[@aria-label='open drawer']");//клик на меню
    private final SelenideElement usersPage = $x("//span[text() = 'Пользователи']");//клик на страницу пользователи
    private final SelenideElement urlNotifications = $x("//*[text()='Значение не является допустимым URL.']");// проверка на некоректный url
    private final SelenideElement inputProjectNotification = $x("//*[text()='Выберите проект']");//проверка на обязательность выбора проекта


    public void clickAddTimeButton() {
        addTimeButton.shouldBe(Condition.enabled).click();
    }

    public void setNameInput(String name) {
        nameInput.shouldBe(Condition.enabled, Duration.ofSeconds(10)).setValue(name);
    }

    public void setStartTime (String startTime ) {
      this.startTime.shouldBe(Condition.enabled).setValue(startTime);
    }

    public void setEndTime(String endTime) {
        this.endTime.shouldBe(Condition.enabled).setValue(endTime);
    }
    public void setProjectName(String name) {
     projectName.shouldBe(Condition.enabled).click();// нажатие на попап элемент Проект
      projectName.setValue(name).pressEnter();
      noOptions.shouldNotBe(Condition.visible);//проверка no options

    }

    public void setDescription(String description) {
       this.description.shouldBe(Condition.enabled).setValue(description);
    }

    public void setInputLink (String inputLink) {
        this.inputLink.shouldBe(Condition.enabled).setValue(inputLink);
    }
    public void verifyTask() {// проверка на успешное создание задачи
        successMessage.shouldBe(Condition.appear);
    }
    public void clickMenuButton() {
        burgerMenu.shouldBe(Condition.enabled).click();
    }
    public void clickUserPage() {
        usersPage.shouldBe(Condition.enabled).click();
    }
    public void verifyErrorNotification() {//проверка на валидность URL
        urlNotifications.shouldBe(Condition.appear);
    }
    public void verifyProjectNotification() {
        inputProjectNotification.shouldBe(Condition.appear);//проверка на обязательность выбора проекта
    }
}