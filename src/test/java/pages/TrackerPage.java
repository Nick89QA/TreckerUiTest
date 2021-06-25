package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.Map;
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
    private final SelenideElement successMessage = $x("//div[text()='Временной промежуток добавлен']");
    private final SelenideElement projectName = $x("//input[@name='project']");//клик на элемент
    private final SelenideElement noOptions = $x("//div[text()='No options']");
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement  usersPage = $x("//span[text() = 'Пользователи']");//клик на страницу пользователи
    private final SelenideElement urlNotifications = $x("//*[text()='Значение не является допустимым URL.']");// проверка на некоректный url
    private final SelenideElement inputProjectNotification = $x("//*[text()='Выберите проект']");//проверка на обязательность выбора проекта
    private final SelenideElement createdProjectName = $x("(//input[@name='project'])[2]");//проверка поля проект
    private final SelenideElement createTaskName = $x("//input[@name='title'])[2]");//проверка поля название
    private final SelenideElement createStartTime = $x("(//input[@name='start'])[2]");//проверка начала времени
    private final SelenideElement createEndTime = $x("(//input[@name='end'])[2]");//проверка конца времени
    private final SelenideElement createDescription = $x(" (//input[@name='description'])[2]"); //проверка описания
    private final SelenideElement createLink = $x("(//input[@name='link'])[2]");//проверка поля ли


    public void verifyTask() {
        successMessage.shouldBe(Condition.appear);
    }

    public void setInputLink (String inputLink) {
        this.inputLink.shouldBe(Condition.enabled).setValue(inputLink);
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

    public void createTask(Map<String, String> map) {
        nameInput.shouldBe(Condition.enabled, Duration.ofSeconds(10)).setValue(map.get("Название"));
        startTime.shouldBe(Condition.enabled).setValue(map.get("Время начала"));
        this.endTime.shouldBe(Condition.enabled).setValue(map.get("Время конец"));
        this.description.shouldBe(Condition.enabled).setValue(map.get("Описание задачи"));
        this.inputLink.shouldBe(Condition.enabled).setValue(map.get("Ссылка на задачу"));
        this.projectName.shouldBe(Condition.enabled).setValue(map.get("Проект")).pressEnter();
        addTimeButton.shouldBe(Condition.enabled).click();

    }

}