package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TrackerPage {
    private final SelenideElement nameInput = $("input[name='title']");
    private final SelenideElement inputProject = $("input[name='project']");//поле выбрать проект
    private final SelenideElement startTime = $("input[name='start']");
    private final SelenideElement endTime = $("input[name='end']");
    private final SelenideElement inputSelectProject = $x("//input[@name='project']");//клик на поле проект
    private final SelenideElement inputLink = $("input[name='link']");
    private final SelenideElement buttonAddTime = $x("//button[@type='submit']/.././button");
    private final SelenideElement successMessage = $x("//div[text()='Временной промежуток добавлен']");
    private final SelenideElement inputDescribeTask = $x("//input[@name='description']");//клик на элемент
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню
    private final SelenideElement pageUser = $x("//span[text()='Пользователи']");//клик на страницу пользователи
    private final SelenideElement urlNotifications = $x("//label[text()='Ссылка на задачу']");// проверка на некоректный url
    private final SelenideElement inputProjectNotification = $x("//*[text()='Выберите проект']");//проверка на обязательность выбора проекта
    private final SelenideElement PageTimer = $x("//span[text()='Таймер']");//клик на страницу таймер
    private final SelenideElement buttonYesterday = $x("//button[@title = 'Предыдущий день']");//клик на предыдущий день
    private final SelenideElement buttonLink = $x("(//button[@id='linksIdButton'])[1]");
    private final SelenideElement linkKnowledgeBase = $x("//a[@href='https://kb.crtweb.ru/']");
    private final SelenideElement linkLongrid = $x("//a[@href='https://longreads.crtweb.ru']");
    private final SelenideElement linkPlatrum = $x("//a[@href='https://crtweb.platrum.ru/regulations']");
    private final SelenideElement linkGit = $x("//a[@href='https://git.crtweb.ru']");
    private final SelenideElement linkCrtTeam = $x("//a[@href='https://crt.team']");
    private final SelenideElement linkSite = $x("//a[@href='https://crtweb.ru']");
    private final SelenideElement linkResume = $x("//a[@href='https://crtweb.ru/developers']");


    public void verifyTask() {
        successMessage.shouldBe(Condition.enabled);
    }

    public void clickMenuButton() {
        burgerMenu
                .shouldBe(Condition.enabled).click();
    }

    public void clickUserPage() {
        pageUser
                .shouldBe(Condition.enabled).click();
    }

    public void verifyErrorNotification() {//проверка на валидность URL
        urlNotifications
                .shouldBe(Condition.appear);
    }

    public void verifyProjectNotification() {
        inputProjectNotification
                .shouldBe(Condition.appear);//проверка на обязательность выбора проекта
    }

    public void AddTimeButton() {
        buttonAddTime
                .shouldBe(Condition.visible)
                .scrollIntoView(true)//скрол к элементу
                .click();
    }

    public void sendNameInput(String name) {
        nameInput
                .should(Condition.enabled).setValue(name);
    }

    public void setStartTime(String time) {
        startTime
                .should(Condition.enabled).setValue(time);
    }

    public void setEndTime(String time) {
        endTime
                .should(Condition.enabled).setValue(time);
    }

    public void setInputSelectProject(String description1) {
        inputSelectProject
                .scrollIntoView(true)
                .should(Condition.visible).setValue(description1);
        Selenide.$x(String.format("//li[text()='%s']", description1)).shouldBe(Condition.enabled).click();
    }

    public void setInputLink(String link) {
        inputLink
                .should(Condition.enabled).setValue(link)
                .pressEnter();
    }

    public void clickDescribeTask(String project) {
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

    public void descriptionPastTask(String pastTask) {
        inputSelectProject
                .should(Condition.enabled).setValue(pastTask);
    }

    public void clickSelectProject(String projectName1) {
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


    public void switchWindow(int num) {
        Selenide.switchTo()
                .window(num);
    }

    public void verifySuccessRedirectKnowledgeBase() {
        webdriver()
                .shouldHave(url("https://kb.crtweb.ru/"));
    }


    public void clickLinkLongrid() {
        linkLongrid
                .should(Condition.enabled)
                .click();
    }


    public void clickLinkPlatrum() {
        linkPlatrum
                .should(Condition.enabled)
                .click();

    }

    public void verifySuccessRedirectLongridPage() {
        webdriver()
                .shouldHave(url("https://longreads.crtweb.ru/"));

    }

    public void verifySuccessRedirectPlatrumPage() {
        webdriver()
                .shouldHave(url("https://crtweb.platrum.ru/regulations"));
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

    public void verifySuccessRedirectGitPage() {
        webdriver()
                .shouldHave(url("https://git.crtweb.ru/users/sign_in"));
    }

    public void verifySuccessRedirectCrtTeamPage() {
        webdriver()
                .shouldHave(url("https://crt.team/"));
    }

    public void clickLinkSite() {
        linkSite
                .should(Condition.enabled)
                .click();
    }

    public void verifySuccessRedirectSitePage() {
        webdriver()
                .shouldHave(url("https://crtweb.ru/developers"));
    }

    public void clickLinkResume() {
        linkResume
                .should(Condition.enabled)
                .click();

    }
}