package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    private final SelenideElement pageProject = $x("//span[text()='Проекты']//..//span");//меню страница проекты
    private final SelenideElement buttonAllProject = $x("//span[text()='Все проекты']");//клик на раздел все проекты
    private final SelenideElement buttonAlfaDirect = $x("//div[@data-panel='panel/api/projects/alfadirect']");//клик на проект альфадирект
    private final SelenideElement checkoutPageProject = $x("//div[@class='_3X1_X']");//проверка на странице проекты
    private final SelenideElement buttonPlusCreateProject = $x("(//div[@role='button'])[1]");//плюсик создание проекта
    private final SelenideElement inputTittleProject = $x("(//input[@type='text'])[2]");//поле название проекта
    private final SelenideElement inputDescribeProject = $x("(//input[@type='text'])[3]");//поле описание проекта
    private final SelenideElement buttonCreateProject = $x("//span[text()='Создать проект']/parent::button");//кнопка создать проект
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement fieldProject = $x("//div[@aria-expanded='false']");//клик на проект
    private final SelenideElement buttonSendToArchive = $x("//span[text()='Архивировать']");//клик на кнопку архив
    private final SelenideElement verifyArchiveProject = $x("//div[text()='Успешно']");//проверка
    private final SelenideElement buttonDetails = $("a[href='/projects/alfadirect']");//кнопка подробнее///
    private final SelenideElement buttonEdit = $x("(//span[text()='Редактировать'])[2]");//кнопка редактировать
    private final SelenideElement inputAddUsers = $x("//div[@aria-haspopup='listbox']");
    private final SelenideElement buttonSave = $x("//span[text()='Сохранить']");
    private final SelenideElement verifyUserProject = $x("//span[text()='Икрин Дмитрий']");
    private final SelenideElement buttonCalendar = $x("//span[text()='Сегодня']");//клик на кнопку календарь
    private final SelenideElement buttonLastMonth = $x("//span[text()='Прошлый месяц']");//клик на кнопку прошлый месяц
    private final SelenideElement buttonTakeReport = $x("//span[text()='Получить отчет']");//проверка получить отчет
    private final SelenideElement inputSelectContractor = $x("//input[@name='contractor']/parent::div");
    private final SelenideElement verifyCreateProject = $x("//div[text()='Успешно']");//проверка создания задачи
    private final SelenideElement inputDeleteProject = $x("//p[text()='01 Test Title']");//проект который находится в архиве
    private final SelenideElement buttonDelete = $x("(//span[text()='Удалить'])[1]");//кнопка удалить
    private final SelenideElement chapterArchive = $x("//span[text()='В архиве']");
    private final SelenideElement verifyDeleteProject = $x("//div[text()='Не удалось удалить проект']");//проверка на удаление проекта
    private final SelenideElement input = $x("//input[@name='project']");//поле поиска
    private final SelenideElement checkMessage = $x("//div[text()='Нет данных']");
    private final SelenideElement verifyFillFields = $x("//div[text()='Неудачно']");
    private final SelenideElement verifyTimeMessage = $x("//div[contains (text(),'project too short')]");

    public void clickButtonAllProject() {
        buttonAllProject
                .shouldBe(Condition.enabled)
                .click();//клик на раздел все проекты
    }

    public void setButtonAlfaDirect() {
        buttonAlfaDirect
                .shouldBe(Condition.enabled)
                .click();// клик на конкретный проект
    }

    public void setMenuProject() {
        pageProject
                .shouldBe(Condition.enabled)
                .click();
    }

    public void setCheckoutPageProject() {
        checkoutPageProject
                .shouldBe(Condition.enabled);
    }

    public void clickButtonSendToArchive() {
        buttonSendToArchive
                .shouldBe(Condition.enabled)
                .click();//клик на архив
    }

    public void verifyArchive() {
        verifyArchiveProject
                .shouldBe(Condition.appear);
    }

    public void clickButtonSave() {//добавления менеджера в проект
        buttonSave
                .shouldBe(Condition.enabled)
                .click();
    }

    public void verifyAddManager() {
        verifyUserProject
                .shouldBe(Condition.enabled).click();
    }

    public void clickButtonLastMonth() {
        buttonLastMonth
                .shouldBe(Condition.enabled)
                .click();//клик на кнопку прошлый месяц
    }

    public void checkReport() {
        buttonTakeReport
                .shouldBe(Condition.enabled)
                .click();//клик на кнопку отчет
    }

    public void clickBurgerMenu() {
        burgerMenu
                .should(Condition.enabled).click();
    }

    public void clickPageProject() {
        pageProject
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonPlusCreateProject() {
        buttonPlusCreateProject
                .should(Condition.enabled).click();
    }

    public void sendInputTittleProject(String title) {
        inputTittleProject
                .should(Condition.enabled)
                .setValue(title);
    }

    public void sendInputDescribeProject(String describe) {
        inputDescribeProject
                .should(Condition.enabled)
                .setValue(describe);
    }

    public void clickButtonCreateProject() {
        buttonCreateProject
                .should(Condition.enabled).click();
    }

    public void clickFieldProject() {
        fieldProject
                .should(Condition.enabled).click();
    }

    public void clickButtonDetails() {
        buttonDetails
                .should(Condition.visible)
                .scrollIntoView(true)
                .click();
    }

    public void clickButtonEdit() {
        buttonEdit
                .should(Condition.enabled).click();
    }

    public void clickButtonAddUsers() {
        inputAddUsers
                .should(Condition.enabled).click();
    }

    public void clickButtonAlfaDirect() {
        buttonAlfaDirect
                .should(Condition.enabled).click();
    }

    public void clickButtonCalendar() {
        buttonCalendar
                .should(Condition.enabled).click();
    }

    public void selectCurrentContractor(String contractor) {
        inputSelectContractor.shouldBe(Condition.enabled).click();
        Selenide.$x(String.format("//li[text()='%s']", contractor))
                .shouldBe(Condition.enabled).click();
    }

    public void checkSuccessProject() {
        verifyCreateProject
                .shouldBe(Condition.appear);
    }

    public void clickInputDeleteProject() {
        inputDeleteProject.should(Condition.enabled)
                .click();
    }
   public void clickButtonDelete() {
        buttonDelete.should(Condition.enabled)
                .click();
   }

   public void clickChapterArchive() {
        chapterArchive.should(Condition.enabled)
                .click();
   }

   public void checkVerifyDeleteProject(){
        verifyDeleteProject
                .should(Condition.appear);
   }


    public void clickInputProject(int data){
        input.should(Condition.enabled)
                .setValue(String.valueOf(data))
                .click();
    }

    public void verifyCheckMessage() {
        checkMessage
                .should(Condition.appear);
    }

    public void checkVerifyFillFields() {
        verifyFillFields
                .should(Condition.appear);
    }


    public void clickInputTittleProject(String title) {
        inputTittleProject
                .should(Condition.enabled)
                .setValue(title);
    }

    public void checkVerifyTimeMessage(){
        verifyTimeMessage
                .should(Condition.appear);
    }
}
