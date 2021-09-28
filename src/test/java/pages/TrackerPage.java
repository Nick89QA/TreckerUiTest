package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import utils.WebUtils;

import java.nio.charset.Charset;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class TrackerPage {
    private final SelenideElement iconProfilePage = $x("//button[@id='accountIdButton']");
    private final SelenideElement buttonProfile = $x("//a[text()='Профиль']");
    private final SelenideElement pageProject = $x("//span[text()='Проекты']//..//span");//меню страница проекты
    private final SelenideElement inputTittle = $("input[name='title']");
    private final SelenideElement inputProject = $("input[name='project']");//поле выбрать проект
    private final SelenideElement startTime = $("input[name='start']");
    private final SelenideElement endTime = $("input[name='end']");
    private final SelenideElement inputLink = $("input[name='link']");
    private final SelenideElement buttonAddTime = $x("//button[@type='submit']/.././button");
    private final SelenideElement successMessage = $x("//div[text()='Временной промежуток добавлен']");
    private final SelenideElement inputDescribeTask = $x("//input[@name='description']");//клик на элемент
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement pageUser = $x("//span[text()='Пользователи']/parent::div");//клик на страницу пользователи
    private final SelenideElement urlNotifications = $x("//label[text()='Ссылка на задачу']");// проверка на некоректный url
    private final SelenideElement inputProjectNotification = $x("//*[text()='Выберите проект']");//проверка на обязательность выбора проекта
    private final SelenideElement PageTimer = $x("//span[text()='Таймер']");//клик на страницу таймер
    private final SelenideElement buttonYesterday = $x("//button[@title = 'Предыдущий день']");//клик на предыдущий день
    private final SelenideElement buttonLink = $x("(//button[@id='linksIdButton'])[1]");
    private final SelenideElement linkKnowledgeBase = $x("//a[@href='https://kb.crtweb.ru/']");
    private final SelenideElement linkLongread = $x("//a[@href='https://longreads.crtweb.ru']");
    private final SelenideElement linkPlatrum = $x("//a[@href='https://crtweb.platrum.ru/regulations']");
    private final SelenideElement linkGit = $x("//a[@href='https://git.crtweb.ru']");
    private final SelenideElement linkCrtTeam = $x("//a[@href='https://crt.team']");
    private final SelenideElement linkSite = $x("//a[@href='https://crtweb.ru']");
    private final SelenideElement linkResume = $x("//a[@href='https://crtweb.ru/developers']");
    private final SelenideElement buttonTimer = $x("(//button[@type='button'])[6]");//клик на кнопку таймер
    private final SelenideElement buttonStart = $x("//span[text()='Старт']/parent::button");//клик на кнопку старт
    private final SelenideElement verifyTimeMessage = $x("//div[contains(text(), 'cannot be')]");
    private final SelenideElement verifyTaskName = $x("//p[contains(text(),'Введите название')]");
    private final SelenideElement wrongTimePeriod = $x("//div[text()='An error occurred']");
    private final SelenideElement loaderProgressBar = $x("(//div[@role='progressbar'])[2]");
    private final SelenideElement projectTaskList = $x("//span[text()='Песок']/parent::div");
    private final SelenideElement buttonDelete = $x("//span[text()='Удалить']");
    private final SelenideElement taskInTaskList = $x("//span[text()='Песок']/parent::div");
    private final SelenideElement buttonSave = $x("//span[text()='Сохранить']");
    private final SelenideElement inputLinkInTaskList = $x("(//input[@name='link'])[2]");//поле ссылка
    private final SelenideElement inputDescribeInTaskList = $x("(//input[@name='description'])[2]");
    private final SelenideElement inputTitleTaskPastTime = $x("(//input[@name='title'])[2]");
    private final SelenideElement titleTaskYesterday = $x("//h3[@title='Написание автотестов для проекта']/parent::td");


    org.apache.logging.log4j.Logger log = LogManager.getLogger(TrackerPage.class.getName());

    public void verifyTask() {
        successMessage.should(Condition.enabled)
                .click();
    }

    public void clickMenuButton() {
        burgerMenu
                .shouldBe(Condition.enabled)
                .click();
    }

    public void clickUserPage() {
        pageUser
                .shouldBe(Condition.enabled)
                .click();
    }

    public void verifyErrorNotification() {//проверка на валидность URL
        try {
            urlNotifications
                    .shouldBe(Condition.appear);
            log.info("Url incorrect");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.error("Url correct");
            Assert.fail("Fail url(Notification did not appear)");
        }

    }

    public void verifyProjectNotification() {
        try {
            inputProjectNotification
                    .shouldBe(Condition.appear);
            log.info("You need to select the project");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            log.error("The project is selected");
            Assert.fail("Fail to create task(Notification did not appear)");
        }

    }

    public void clickAddTimeButton() {
        buttonAddTime
                .shouldBe(Condition.visible)
                .scrollIntoView(true)
                .click();
    }

    public void sendInputTittle(String title) {
        WebUtils.clearField(inputTittle);
        inputTittle
                .should(Condition.enabled).setValue(title);
    }

    public void setStartTime(String time) {
        WebUtils.clearField(startTime);
        startTime
                .should(Condition.enabled).setValue(time);
    }

    public void setEndTime(String time) {
        WebUtils.clearField(endTime);
        endTime
                .should(Condition.enabled).setValue(time);
    }


    public void setInputLink(String link) {
        WebUtils.clearField(inputLink);
        inputLink
                .should(Condition.enabled).setValue(link)
                .pressEnter();
    }

    public void clickDescribeTask(String project) {
        WebUtils.clearField(inputDescribeTask);
        inputDescribeTask
                .should(Condition.enabled).setValue(project);
    }

    public void clickBurgerMenu() {
        burgerMenu
                .should(Condition.enabled).click();
    }

    public void ClickPageTimer() {
        PageTimer
                .should(Condition.enabled).click();
    }

    public void ClickButtonYesterday() {
        buttonYesterday
                .should(Condition.enabled).click();
    }

    public void setInputLinkPastTime(String past) {
        inputLink
                .should(Condition.enabled).setValue(past);
    }


    public void clickSelectProject(String projectName1) {
        WebUtils.clearField(inputProject);
        inputProject
                .should(Condition.enabled).setValue(projectName1).pressEnter();

    }

    public void clickButtonLink() {
        buttonLink
                .should(Condition.enabled)
                .click();
    }

    public void clickLinkKnowledgeBase() {
        linkKnowledgeBase
                .should(Condition.enabled)
                .click();
    }


    public void clickLinkLongread() {
        linkLongread
                .should(Condition.enabled)
                .click();
    }


    public void clickLinkPlatrum() {
        linkPlatrum
                .should(Condition.enabled)
                .click();

    }


    public void clickLinkGit() {
        linkGit
                .should(Condition.enabled)
                .click();
    }

    public void clickLinkCrtTeam() {
        linkCrtTeam
                .should(Condition.enabled)
                .click();
    }


    public void clickLinkSite() {
        linkSite
                .should(Condition.enabled)
                .click();
    }


    public void clickLinkResume() {
        linkResume
                .should(Condition.enabled)
                .click();

    }

    public void clickPageProject() {
        pageProject
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonTimer() {
        buttonTimer
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonStart() {
        buttonStart
                .should(Condition.enabled)
                .click();
    }

    public void checkVerifyTimeMessage() {
        verifyTimeMessage
                .should(Condition.enabled)
                .click();
    }

    public void checkVerifyTaskName() {
        verifyTaskName
                .should(Condition.appear);

    }

    public void clickIconProfilePage() {
        iconProfilePage.should(Condition.enabled)
                .click();
    }

    public void clickButtonProfile() {
        buttonProfile.should(Condition.enabled)
                .click();
    }

    public void checkWrongTimePeriod() {
        wrongTimePeriod
                .should(Condition.visible);
    }

    public String generateSymbol() {

        byte[] array = new byte[300]; // длинна символов
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    public void sendLongTittle() {
        WebUtils.clearField(inputTittle);
        inputTittle
                .should(Condition.enabled)
                .setValue(generateSymbol());
    }

    public void checkLoaderProgressBar() {
        loaderProgressBar
                .should(Condition.visible);
    }

    public void clickProjectTaskList() {
        projectTaskList
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonDelete() {
        buttonDelete
                .should(Condition.enabled)
                .click();
    }

    public void checkTaskInTaskList() {
        taskInTaskList
                .should(Condition.visible);
    }

    public void clickTaskInTaskList() {
        taskInTaskList
                .should(Condition.enabled)
                .click();
    }

    public void clickButtonSave() {
        buttonSave
                .should(Condition.enabled)
                .click();
    }

    public void clickInputLinkInTaskList(String link) {
        WebUtils.clearField(inputLinkInTaskList);
        inputLinkInTaskList
                .should(Condition.enabled)
                .setValue(link);
    }

    public void clickInputDescribeInTaskList(String describe) {
        WebUtils.clearField(inputDescribeInTaskList);
        inputDescribeInTaskList
                .should(Condition.enabled)
                .setValue(describe);
    }

    public void clickTaskPastTime() {
        titleTaskYesterday
                .should(Condition.enabled)
                .scrollIntoView(true)
                .click();
    }


    public void sendTitlePastTime(String title) {
        WebUtils.clearField(inputTitleTaskPastTime);
        inputTitleTaskPastTime
                .scrollIntoView(true)
                .should(Condition.enabled).setValue(title);
    }

}