package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    private final SelenideElement menuProject = $x("//span[text()='Проекты']");//меню страница проекты
    private final SelenideElement buttonAllProject = $x("//span[text()='Все проекты']");//клик на раздел все проекты
    private final SelenideElement buttonAlfaDirect = $x("//div[@data-panel='panel/api/projects/alfadirect']");//клик на проект альфадирект
    private final SelenideElement checkoutPageProject = $x("//div[@class='_3X1_X']");//проверка на странице проекты
    private final SelenideElement buttonCreateProject = $x("(//div[@role='button'])[1]");//плюсик создание проекта
    private final SelenideElement inputTittleProject = $x("(//input[@type='text'])[2]");//поле название проекта
    private final SelenideElement inputDescribeProject = $x("(//input[@type='text'])[3]");//поле описание проекта
    private final SelenideElement popupElement = $x("//li[text()='asd']");//элемент Creative в попап
    private final SelenideElement createProjectButton = $x("//span[text() ='Создать проект']");//кнопка создать проект
    private final SelenideElement clickInputPerformer = $x("//label[text()='Подрядчик/Исполнитель']/div/div");//клик на поле подрядчик
    private final SelenideElement checkoutCreateProject = $x("(//div[@class='MuiAccordionSummary-content'])[3]");//проверка созданного проекта
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement clickOnProject = $x("//div[@aria-expanded='false']");//клик на проект
    private final SelenideElement clickOnArchiveButton = $x("//span[text()='Архивировать']");//клик на кнопку архив
    private final SelenideElement verifyArchiveProject = $x("//div[text()='Успешно']");//проверка
    private final SelenideElement buttonDetails = $x("//span[text()='Подробнее']");//кнопка подробнее
    private final SelenideElement buttonEdit = $x("(//span[text()='Редактировать'])[2]");//кнопка редактировать
    private final SelenideElement clickOnUser = $x("//div[@aria-haspopup='listbox']");
    private final SelenideElement buttonSave = $x("//span[text()='Сохранить']");
    private final SelenideElement verifyUserProject = $x("//span[text()='Икрин Дмитрий']");
    private final SelenideElement buttonCalendar = $x("//span[text()='Сегодня']");//клик на кнопку календарь
    private final SelenideElement buttonLastMonth = $x("//span[text()='Прошлый месяц']");//клик на кнопку прошлый месяц
    private final SelenideElement buttonTakeReport = $x("//span[text()='Получить отчет']");//проверка получить отчет


    public void setButtonAllProject() {
        buttonAllProject.shouldBe(Condition.enabled).click();//клик на раздел все проекты
    }

    public void setButtonAlfaDirect() {
        buttonAlfaDirect.shouldBe(Condition.enabled).click();// клик на конкретный проект
    }

    public void setMenuProject() {
        menuProject.shouldBe(Condition.enabled).click();
    }

    public void setCheckoutPageProject() {
        checkoutPageProject.shouldBe(Condition.enabled);
    }

    public void createProject(Map<String, String> map) {
        burgerMenu.shouldBe(Condition.enabled).click();
        menuProject.shouldBe(Condition.enabled).click();
        buttonCreateProject.shouldBe(Condition.enabled).click();
        inputTittleProject.shouldBe(Condition.enabled).setValue(map.get("Название проекта"));
        inputDescribeProject.shouldBe(Condition.enabled).setValue(map.get("Описание"));
        clickInputPerformer.shouldBe(Condition.enabled).click();
        Selenide.$x(String.format("//li[text()='%s']", map.get("Подрядчик/Исполнитель"))).click();
        createProjectButton.shouldBe(Condition.enabled).click();
    }

    public void addProjectToArchive() {
        burgerMenu.shouldBe(Condition.enabled).click();
        menuProject.shouldBe(Condition.enabled).click();//меню проекта
        clickOnProject.shouldBe(Condition.enabled).click();//клик на проекты
        clickOnArchiveButton.shouldBe(Condition.enabled).click();//клик на архив
    }

    public void verifyArchive() {
        verifyArchiveProject.shouldBe(Condition.appear);
    }

    public void addManagerToProject(Map<String, String> map) {//добавления менеджера в проект
        burgerMenu.shouldBe(Condition.enabled).click();//клик на бургер меню
        menuProject.shouldBe(Condition.enabled).click();//клик на стран проекты
        clickOnProject.shouldBe(Condition.enabled).click();//клик на стран проекты
        buttonDetails.shouldBe(Condition.enabled).click();//клик на кнопку подробнее
        buttonEdit.shouldBe(Condition.enabled).click();//клик на кнопку редактировать
        clickOnUser.shouldBe(Condition.enabled).click();//клик на поле перед введением данных
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).click();//клик на юзера
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).pressEscape();//нажатие на escape
        buttonSave.shouldBe(Condition.enabled).click();
    }

    public void verifyAddManager() {
        verifyUserProject.shouldBe(Condition.enabled).click();
    }

    public void ReviewReport() {
        burgerMenu.shouldBe(Condition.enabled).click();//клик на бургер меню
        menuProject.shouldBe(Condition.enabled).click();//клик на стран проекты
        buttonAllProject.shouldBe(Condition.enabled).click();//клик на раздел все проекты
        buttonAlfaDirect.shouldBe(Condition.enabled).click();//клик на проект альфаДирект
        buttonDetails.shouldBe(Condition.enabled).click();//клик на кнопку Подробнее
        buttonCalendar.shouldBe(Condition.enabled).click();//клик на кнопку календарь
        buttonLastMonth.shouldBe(Condition.enabled).click();//клик на кнопку прошлый месяц

    }

    public void checkReport() {
        buttonTakeReport.shouldBe(Condition.enabled).click();//клик на кнопку отчет
    }
}
