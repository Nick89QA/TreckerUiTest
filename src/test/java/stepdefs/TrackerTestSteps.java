
package stepdefs;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import org.testng.asserts.SoftAssert;
import pages.*;
import pages.AutorizationPage;
import pages.UsersPage;
import com.codeborne.selenide.Selenide;
import utils.WebUtils;

import java.util.List;
import java.util.Map;

public class TrackerTestSteps {
    private AutorizationPage autorizationPage = Selenide.page(AutorizationPage.class);
    private TrackerPage trackerPage = Selenide.page(TrackerPage.class);
    private UsersPage usersPage = Selenide.page(UsersPage.class);
    private ProjectPage projectPage = Selenide.page(ProjectPage.class);
    private ContractorPage contractorPage = Selenide.page(ContractorPage.class);
    private ReportingPage reportingPage = Selenide.page(ReportingPage.class);
    private ProfilePage profilePage = Selenide.page(ProfilePage.class);
    private WebUtils webUtils = Selenide.page(WebUtils.class);

    @Дано("^Пользователь авторизуется на сайте трекера$")
    public void authorize() {
        autorizationPage.clickAuth();
        webUtils.switchWindow("Вход – Google Аккаунты");
        autorizationPage.sendInputEmail("nip@crtweb.ru");
        autorizationPage.clickNext();
        autorizationPage.sendInputPassword("nick2004");
        autorizationPage.clickNext();
        webUtils.switchWindow("Creative Integrator");
        Selenide.sleep(6000);//Обход авторизации гугла
    }

    @Когда("^Пользователь создает задачу с параметрами$")
    public void createTask(Map<String, String> map) {
        trackerPage.sendInputTittle(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.clickAddTimeButton();

    }

    @Когда("^Пользователь создает задачу используя прошлый временной промежуток$")
    public void createTaskPastTime(Map<String, String> map) {
        trackerPage.clickBurgerMenu();
        trackerPage.ClickPageTimer();
        trackerPage.ClickButtonYesterday();
        trackerPage.sendInputTittle(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLinkPastTime(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.clickAddTimeButton();
    }

    @Когда("^Пользователь заходит на страницу с проектами$")
    public void userOnProjectPage() {
        trackerPage.clickMenuButton();
        projectPage.setMenuProject();
        projectPage.clickButtonAllProject();
        projectPage.setButtonAlfaDirect();
    }

    @Тогда("^задача создана корректно$")
    public void verifyTask() {
        trackerPage.verifyTask();
    }

    @Когда("^Пользователь переходит на страницу Пользователи$")
    public void goToUsersPage() {
        trackerPage.clickMenuButton();
        trackerPage.clickUserPage();
    }

    @Тогда("^результат поиска содержит (.*)$")
    public void searchResult(String text) {
        usersPage.verifySearch(text);
    }

    @Тогда("^пользователь ищет по параметрам и убеждается в успехе$")
    public void verifySuccessSearch(List<String> textList) {
        for (String s : textList) {
            usersPage.setSearchField(s);
            usersPage.verifySearch(s);
        }
    }

    @Когда("^Пользователь заходит на страницу Пользователя и ищет свою фамилию$")
    public void userGoToUserPage(Map<String, String> map) {
        usersPage.clickBurgerMenu();
        usersPage.clickPageUser();
        usersPage.searchSurName(map.get("Фамилия"));
    }

    @Тогда("^пользователь получает уведомление о некорректной ссылке$")
    public void verifyErrorNotification() {
        trackerPage.verifyErrorNotification();
    }

    @Тогда("^пользователь получает уведомление о необходимости выбора проекта$")
    public void verifyProjectNotification() {
        trackerPage.verifyProjectNotification();
    }

    @Тогда("^Пользователь может просматривать информацию о проекте$")
    public void verifyProjectPage() {
        projectPage.setCheckoutPageProject();
    }

    @Тогда("^пользователь видит созданный подряд в списке подрядчиков$")
    public void verifyCreateContract() {
        contractorPage.checkNewContract();
    }

    @Когда("^Пользователь заходит на страницу с подрядчиками$")
    public void userGoToContractPage() {
        contractorPage.clickBurgerMenu();
        contractorPage.clickButtonMenuContract();
    }

    @Тогда("^Пользователь убеждается о доступности подрядчиков на странице$")
    public void checkAvailableContractPage() {
        contractorPage.checkContractPage();
    }

    @Когда("^Пользователь заходит на страницу отчетности$")
    public void userGoToReportingPage() {
        reportingPage.clickBurgerMenu();
        reportingPage.clickPageReport();
        reportingPage.clickButtonCalendar();
        reportingPage.clickButtonLastMonth();
    }

    @Тогда("^Пользователь убеждается о доступности отчетности за прошлый месяц$")
    public void verifyReports() {
        reportingPage.checkRightResult();
    }

    @Когда("^Пользователь добавляет свой проект в архив$")
    public void userAddProjectToArchive() {
        projectPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickFieldProject();
        projectPage.clickButtonSendToArchive();
    }

    @Тогда("^Пользователь убеждается об успешном добавлении проекта в архив$")
    public void checkToaddingProject() {
        projectPage.verifyArchive();
    }

    @Когда("^Пользователь создает подряд на странице с подрядами$")
    public void userCreateNewContract(Map<String, String> map) {
        contractorPage.clickBurgerMenu();
        contractorPage.clickButtonMenuContract();
        contractorPage.clickButtonCreateContract();
        contractorPage.setInputFullTittle(map.get("Полное название"));
        contractorPage.setInputShortName(map.get("Короткое название"));
        contractorPage.clickButtonCreate();
    }

    @Когда("^Пользователь создает новый проект$")
    public void createNewTask(Map<String, String> map) {
        projectPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.sendInputTittleProject(map.get("Название проекта"));
        projectPage.sendInputDescribeProject(map.get("Описание"));
        projectPage.selectCurrentContractor(map.get("Подрядчик/Исполнитель"));
        projectPage.clickButtonCreateProject();
    }


    @Тогда("^Пользователь убеждается об успешном нахождении данной фамилии$")
    public void userVerifyResult() {
        usersPage.verifyResult();
    }

    @Когда("^Пользователь заходит в свой проект и добавляет туда менеджера$")
    public void userAddManagerToProject(Map<String, String> map) {
        projectPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickButtonDetails();
        projectPage.clickButtonEdit();
        projectPage.clickButtonAddUsers();
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).click();
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).pressEscape();
        projectPage.clickButtonSave();
    }

    @Тогда("^Пользователь убеждается об успешном добавлении менеджера в свой проект$")
    public void verifyAddingManager() {
        projectPage.verifyAddManager();
    }

    @Когда("^Пользователь заходит на страницу с проектами AlfaDirect и открывает отчет за прошлый месяц$")
    public void reviewReportForLastMonth() {
        projectPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonLastMonth();

    }

    @Тогда("^Пользователь убеждается об успешном просмотре отчета по проекту$")
    public void verifySuccessReport() {
        projectPage.checkReport();
    }

    @Когда("^Пользователь авторизуется в трекере используя некорректный email '(.*)'$")
    public void authorizationWithIncorrectEmail(String email) {
        autorizationPage.clickButtonAuthorization();
        webUtils.switchWindow("Вход – Google Аккаунты");
        autorizationPage.clickInputEmail(email);
        autorizationPage.clickButtonNext();
    }

    @Тогда("^Пользователь убеждается об введении некорректного email$")
    public void userMakeSureIncorrectEmail() {
        autorizationPage.verifyIncorrectEmail();
    }

    @Когда("^Пользователь аторизуется в трекере используя некорректный пароль$")
    public void AuthorizeWithIncorrectPassword(Map<String, String> map) {
        autorizationPage.clickButtonAuthorization();
        webUtils.switchWindow("Вход – Google Аккаунты");
        autorizationPage.clickInputEmail(map.get("Корректный имейл"));
        autorizationPage.clickButtonNext();
        autorizationPage.sendInputIncorrectPassword(map.get("Некорректный пароль"));
        autorizationPage.clickButtonNext();

    }

    @Тогда("^Пользователь убеждается об введении некорректного пароля$")
    public void userVerifyIncorrectPassword() {
        autorizationPage.incorrectPassword();
    }

    @Когда("^Пользователь заходит на страницу с подрядами и удаляет подряд$")
    public void DeleteContract() {
        contractorPage.clickBurgerMenu();
        contractorPage.clickButtonMenuContract();
        contractorPage.scrollInputDeleteContract();
        contractorPage.clickInputContract();
        contractorPage.clickButtonEditContract();
        contractorPage.clickButtonBasket();
        contractorPage.clickButtonDelete();
    }

    @Тогда("^Пользователь убеждается об успешном удалении подряда$")
    public void verifyDeleteContract() {
        contractorPage.verifyDeleteContract();
    }

    @Когда("^Пользователь редактирует информацию о подрядчике$")
    public void userCanEditContract(Map<String, String> map) {
        contractorPage.clickBurgerMenu();
        contractorPage.clickButtonMenuContract();
        contractorPage.clickInputContract();
        contractorPage.clickButtonEditContract();
        contractorPage.sendInputName(map.get("Добавление информации"));
        contractorPage.clickButtonSave();
    }

    @Тогда("^Пользователь убеждается об успешном редактировании информации о подрядчике$")
    public void verifySuccessEdit() {
        contractorPage
                .verifyEditContract();
    }

    @Тогда("^Пользователь убеждается об успешном создании проекта$")
    public void userCheckSuccessCreateContract() {
        projectPage
                .checkSuccessProject();
    }


    @Когда("^Пользователь заходит на страницу Профиль и смотрит отчет по проектам$")
    public void userGoToProfilePageAndSeeReportForProject() {
        profilePage.clickIconButton();
        profilePage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonLastMonth();
        profilePage.clickCloseDropDownCalendar();

    }

    @Тогда("^Пользователь убеждается о доступности отчета на странице Профиль за прошлый месяц$")
    public void userSureAboutValiableReportForLastMonth() {
        profilePage.checkVerifyLastMonth();
    }

    @Когда("^Пользователь заходит на страницу Профиль$")
    public void userGoToProfilePage() {
        profilePage.clickIconButton();
        profilePage.clickButtonProfile();
    }

    @Тогда("^Пользователь убеждается о доступном просмотре своей роли на странице Профиль$")
    public void userMakeSureAboutAvailableRoleOnProject() {
        profilePage.verifyCheckRoleOnPage();
    }


    @Тогда("^Пользователь убеждается об успешном редактировании электронной почты$")
    public void userMakeSureAboutSuccessEditEmail() {
        profilePage.checkMessageNotificationSuccess();
    }


    @Тогда("^Пользователь убеждается об успешном изменении формата даты на странице$")
    public void userMakeSureSuccessEditDateFormat() {
        profilePage.checkMessageNotificationSuccess();
    }


    @Тогда("^Пользователь убеждается об успешном изменении формата времени на странице профиль$")
    public void userMakeSureSuccessEditTimeFormat() {
        profilePage.checkMessageNotificationSuccess();
    }


    @Тогда("^Пользователь успешно редактирует свое имя на странице Профиль$")
    public void userSuccessEditNameOnProfilePage() {
        profilePage.checkMessageNotificationSuccess();
    }


    @Тогда("^Пользователь убеждается об успешном редактировании своей фамилии на странице$")
    public void userMakeSureInSuccessEditLastName() {
        profilePage.checkMessageNotificationSuccess();
    }

    @Когда("^Пользователь создает задачу с некоректными  параметрами$")
    public void userCreateTwoTasksOnBorderTime(Map<String, String> map) {
        trackerPage.clickBurgerMenu();
        trackerPage.ClickPageTimer();
        trackerPage.ClickButtonYesterday();
        trackerPage.sendInputTittle(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLinkPastTime(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));//дописать задачу
        trackerPage.clickAddTimeButton();
    }

    @Тогда("^Пользователь убеждается об успешном создании задач$")
    public void userMakeSureSuccessCreateTasks() {
        trackerPage.verifyTask();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу База знаний$")
    public void userRedirectFromMainPageToPageKnowledgeBase() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkKnowledgeBase();
    }

    @Тогда("^Пользователь убеждается об успешном переходе на страницу База знаний$")
    public void userMakeSureSuccessRedirectPageKnowledgeBase() {
        webUtils.switchWindow("Creative Integrator");

    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Лонгриды$")
    public void userRedirectFromMainPageToPagelongrid() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkLongread();
    }

    @Тогда("^Пользователь убеждается об успешном переходе на страницу Лонгриды$")
    public void userMakeSureSuccessRedirectPageLongrid() {
        webUtils.switchWindow("Creative Integrator");
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Платрум$")
    public void userRedirectFromMainPageToPagePlatrum() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkPlatrum();
    }

    @Тогда("^Пользователь убеждается об успешном переходе на страницу Платрум$")
    public void userMakeSureSuccessRedirectPagePlatrum() {
        webUtils.switchWindow("Creative Integrator");
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Гит$")
    public void userRedirectFromMainPageToPageGit() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkGit();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Гит$")
    public void userMakeSureSuccessRedirectPageGit() {
        //  WebUtils.switchWindow();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу CRT.TEAM$")
    public void userRedirectFromMainPageToPageCrtTeam() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkCrtTeam();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу CRT.TEAM$")
    public void userMakeSureSuccessRedirectPageCrtTeam() {
        webUtils.switchWindow("Creative Integrator");
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Сайт$")
    public void userRedirectFromMainPageToPageSite() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkSite();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Сайт$")
    public void userMakeSureSuccessRedirectPageSite() {
        webUtils.switchWindow("Creative Integrator");

    }


    @Когда("^Пользователь переходит с главной страницы трекера на страницу Резюме специалистов$")
    public void userRedirectFromMainPageToPageResume() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkResume();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Резюме специалистов$")
    public void userMakeSureSuccessRedirectPageResume() {
        webUtils.switchWindow("Creative Integrator");


    }

    @Когда("^Пользователь заполняет данные на странице Профиля$")
    public void userSetProfileSettings(Map<String, String> map) {
        profilePage.clickIconButton();
        profilePage.clickButtonProfile();
        profilePage.clickButtonEdit();
        profilePage.setProfilePageInputs(map);
        profilePage.clickButtonSave();
    }

    @Тогда("^Пользователь убеждается что данные профиля заполнились корректно$")
    public void verifyTextOnProfilePage(Map<String, String> map) {
        Map<String, String> actualMap = profilePage.getProfileInfo();
        SoftAssert softAssert = new SoftAssert();
        for (String key : map.keySet()) {
            softAssert.assertEquals(actualMap.get(key), map.get(key));
        }
        softAssert.assertAll();
    }


    @Когда("^Пользователь заходит на страницу с проектами и удаляет проект из Архива$")
    public void userGoToPageWithProjectsAndDeleteProjectFromArchive() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickChapterArchive();
        projectPage.clickInputDeleteProject();
        projectPage.clickButtonDelete();
    }

    @Тогда("^Пользователь получает уведомление об отсутствии прав на удаление проекта$")
    public void userSetNotificationAboutFailureDeleteProject() {
        projectPage.checkVerifyDeleteProject();
    }

    @Когда("^Пользователь переходит на страницу Проекты и вводит в поиск невалидные данные$")
    public void userGoToProjectPageAndEntersInvalidData() {
        trackerPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickInputProject(123456);
    }

    @Тогда("^Пользователь получает уведомление об отсутствии проектов с таким названием$")
    public void userGetNotificationAboutAbsenceProjectsWithTittle() {
        projectPage.verifyCheckMessage();
    }

    @Когда("^Пользователь заходит на страницу с проектами и создает проект без данных$")
    public void userGoToPageAndCreateProjectWithoutData() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.clickButtonCreateProject();

    }

    @Тогда("^Пользователь получает уведомление об необходимости заполнения полей$")
    public void userGetNotificationAboutFillingTheFields() {
        projectPage.checkVerifyFillFields();
    }

    @Когда("^Пользователь переходит на страницу с проектами и вводит только название проекта$")
    public void userGoToPageWithProjectAndFillOnlyProjectName() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.clickInputTittleProject("Написание автотестов");
        projectPage.clickButtonCreateProject();
    }

    @Когда("^Пользователь заходит на страницу с проектами и создает проект без выбора подрядчика$")
    public void userGoToPageWithProjectAndCreateProjectWithoutContractor() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.clickInputTittleProject("Написание автотестов на трекер");
        projectPage.sendInputDescribeProject("Автотесты на трекер");
        projectPage.clickButtonCreateProject();
    }


    @Тогда("^Пользователь получает уведомление о неверно выбранном временном промежутке$")
    public void userGetNotificationAboutWrongTimeLine() {
        projectPage.checkVerifyTimeMessage();
    }

    @Когда("^Пользователь заходит на страницу Таймер запускает таймер в текущем времени и останавливает его менее чем за минуту$")
    public void userVisitTimerPageStartsTheTimerAtCurrentTimeAndStopsItInLessThanMinute() {
        trackerPage.clickButtonTimer();
        trackerPage.sendInputTittle("Новые автотесты на трекер");
        trackerPage.clickSelectProject("Песок");
        trackerPage.clickButtonStart();
        Selenide.sleep(10000);
        trackerPage.clickButtonTimer();
    }


    @Тогда("^Пользователь получает уведомление о невалидном временном промежутке$")
    public void userGetNotificationAboutInvalidTimeLine() {
        trackerPage.checkVerifyTimeMessage();
    }

    @Когда("^Пользователь заходит на страницу Проекты и создает проект выбрав только Подрядчика$")
    public void userGoToProjectPageAndCreateProjectWithoutParameters() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.selectCurrentContractor("цукцук");
        projectPage.clickButtonCreateProject();
    }


    @Когда("^Пользователь переходит на страницу Таймер и создает задачу без параметров$")
    public void userGoToTimerPageAndCreateTaskWithoutParams() {
        trackerPage.clickAddTimeButton();
    }

    @Тогда("^Пользователь получает уведомление об необходимости выбрать название для задачи$")
    public void userGetNotificationToChooseTaskName() {
        trackerPage.checkVerifyTaskName();
    }

    @Когда("^Пользователь переходит на страницу с Пользователями и ищет сотрудников по невалидным данным$")
    public void userGoToUsersPageAndSearchEmployeesToInvalidData() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickUserPage();
        usersPage.setSearchField("adadadasdasdasd");
    }

    @Тогда("^Пользователь видит сообщение об отсутствии таких пользователей$")
    public void userSeesMessageAboutTheAbsenceUsers() {
        usersPage.verifyMessageAbsence();
    }

    @Когда("^Пользователь заходит на страницу с проектами и пользуется пагинацией$")
    public void userGoToProjectPageAndUsePagination() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickUserPage();
        usersPage.clickPaginationPageOne();
    }

    @Тогда("^При каждом клике на страницу на которой находится пользователь страница обновляется$")
    public void eachTimeTheUserClicksOnThePageTheUserIsOnThePageIsUpdated() {
        usersPage.verifyCheckPagination();
    }

    @Когда("^Пользователь переходит в календарь и просматривает информацию по проектам за вчерашний день$")
    public void userGoesToTheCalendarViewsInformationOnProjectsForTheDayBefore() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonYesterday();
        profilePage.clickCloseDropDownCalendar();
    }

    @Тогда("^Пользователь убеждается об отсутствии отчета за данный период$")
    public void userMakeSureOfTheAbsenceReportForGivenPeriod() {
        profilePage.verifyTimeUserOnProject();
    }

    @Когда("^Пользователь переходит в календарь просматривает информацию по проектам за текущую неделю$")
    public void userGoesToTheCalendarViewsInformationOnProjectsForTheCurrentWeek() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonCurrentWeek();
        profilePage.clickCloseDropDownCalendar();
    }

    @Когда("^Пользователь переходит в календарь и просматривает информацию по проектам за прошлую неделю$")
    public void userGoesToTheCalendarViewsInformationOnProjectsForTheLastWeek() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonLastWeek();
        profilePage.clickCloseDropDownCalendar();
        profilePage.clickDropDownListAllProjects();
        profilePage.clickDropDownListSpecificProject();
    }

    @Тогда("^Пользователь видит информацию по проекту Добавление логирование на проект$")
    public void userSeeInformationOnProjectAddingLoggingToProject() {
        profilePage.verifyCheckProjectLogging();
    }

    @Когда("^Пользователь переходит в календарь и просматривает информацию по проектам за текущий месяц$")
    public void userGoesToTheCalendarViewsInformationOnProjectsForTheCurrentMonth() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonCurrentMonth();
        profilePage.clickCloseDropDownCalendar();
        profilePage.clickDropDownListAllProjects();
    }

    @Тогда("^Пользователь видит информацию по проектам за текущий месяц$")
    public void userSeeInformationOnProjectsForTheCurrentMonth() {
        profilePage.checkVerifyProject();
    }

    @Когда("^Пользователь заходит в календарь и смотрит информацию по конкретному проекту за прошлую неделю$")
    public void userGoesToTheCalendarViewsInformationOnSpecificProjectForLastWeek() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonLastWeek();
        profilePage.clickCloseDropDownCalendar();
        profilePage.clickDropDownListAllProjects();
    }

    @Тогда("^Пользователь видит информацию по проекту за прошлую неделю$")
    public void userSeeInformationOnProjectForLastWeek() {
        profilePage.checkVerifyProjectLastWeek();
    }

    @Когда("^Пользователь заходит в календарь и смотрит информацию по конкретному проекту за прошлый месяц$")
    public void userGoesToTheCalendarViewsInformationOnSpecificProjectsForTheLastMonth() {
        trackerPage.clickIconProfilePage();
        trackerPage.clickButtonProfile();
        profilePage.clickButtonCalendar();
        profilePage.clickButtonLastMonth();
        profilePage.clickCloseDropDownCalendar();
    }

    @Тогда("^Пользователь видит информацию по проекту за прошлый месяц$")
    public void userSeeInformationOnProjectForLastMonth() {
        profilePage.checkVerifyProjectLastMonth();
    }

    @Когда("^Пользователь просматривает отчет по проекту за сегодня$")
    public void userIsViewingTheProjectReportForToday() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonToday();
        profilePage.clickCloseDropDownCalendar();

    }

    @Тогда("^Пользователь убеждается об отсутствии отчета за сегодня$")
    public void userMakeSureThatThereIsNoReportForToday() {
        projectPage.verifyCheckMessage();
    }

    @Когда("^Пользователь просматривает отчет по проекту за вчера$")
    public void userSeeReportOnProjectForYesterday() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonYesterday();
        profilePage.clickCloseDropDownCalendar();

    }

    @Тогда("^Пользователь убеждается об отсутствии отчета за вчера$")
    public void userMakeSureThatThereIsNoReportForYesterday() {
        projectPage.checkMessageNoData();
    }

    @Когда("^Пользователь просматривает отчет по проекту за текущую неделю$")
    public void userSeeReportOnProjectForCurrentWeek() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonCurrentWeek();
        profilePage.clickCloseDropDownCalendar();
    }

    @Тогда("^Пользователь убеждается об отсутствии отчета за текущую неделю$")
    public void userMakeSureThatThereIsNoReportForCurrentWeek() {
        projectPage.checkMessageNoData();
    }

    @Когда("^Пользователь просматривает отчет по проекту за прошлую неделю$")
    public void userSeeReportOnProjectForLastWeek() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonLastWeek();
        profilePage.clickCloseDropDownCalendar();
    }

    @Тогда("^Пользователь просматривает отчет за прошлую неделю$")
    public void userSeeReportForLastWeek() {
        projectPage.checkButtonGetReport();
    }

    @Когда("^Пользователь просматривает отчет по проекту за текущий месяц$")
    public void userSeeReportToProjectLastMonth() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonCurrentMonth();
        profilePage.clickCloseDropDownCalendar();

    }

    @Тогда("^Пользователь просматривает отчет за текущий месяц$")
    public void userSeeReportForCurrentMonth() {
        projectPage.checkButtonGetReport();
    }

    @Когда("^Пользователь просматривает отчет по проекту за прошлый месяц$")
    public void userSeeReportToProjectForLastMonth() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickPageProject();
        projectPage.clickButtonAllProject();
        projectPage.clickButtonAlfaDirect();
        projectPage.clickButtonDetails();
        projectPage.clickButtonCalendar();
        projectPage.clickButtonLastMonth();
        profilePage.clickCloseDropDownCalendar();
    }


    @Тогда("^Пользователь просматривает отчет за прошлый месяц$")
    public void userSeeReportForLastMonth() {
        projectPage.checkMessageNoData();
    }

    @Тогда("^Пользователь получает уведомление о некорректном временном промежутке$")
    public void userGetNotificationToIncorrectTimePeriod() {
        trackerPage.checkWrongTimePeriod();
    }

    @Когда("^Пользователь создает задачу с длинным названием$")
    public void userCreateTaskWithLongName(Map<String, String> map) {
        trackerPage.sendLongTittle();
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.clickAddTimeButton();
    }

    @И("^Пользователь удаляет созданную задачу$")
    public void userDeleteCreatedTask() {
        trackerPage.clickProjectTaskList();
        trackerPage.clickButtonDelete();
    }

    @Тогда("^Пользователь убеждается в удалении задачи$")
    public void userMakeSureInTheDeletionOfTheTask() {
        trackerPage.checkLoaderProgressBar();
    }

    @Тогда("^Пользователь видит созданную задачу в списке задач$")
    public void userSeeCreatedTaskInTaskList() {
        trackerPage.checkTaskInTaskList();
    }


    @Когда("^Пользователь заходит в созданную задачу и добавляет ссылку и описание$")
    public void userGoToCreatedTaskAndAddLinkAndDescription() {
        trackerPage.clickTaskInTaskList();
        trackerPage.clickInputLinkInTaskList("https://git.crtweb.ru/creative/");
        trackerPage.clickInputDescribeInTaskList("Внедрение отчетов Allure на проекте Creative Integrator");
        trackerPage.clickButtonSave();
    }

    @Тогда("^Пользователь убеждается в сохранении задачи$")
    public void userMakeSureThatTaskIsSaved() {
        trackerPage.checkLoaderProgressBar();
    }

    @Когда("^Пользователь добавляет роли другим пользователям и сохраняет результат$")
    public void userAddRoleOtherUsersAndSaveResults() {
        trackerPage.clickBurgerMenu();
        trackerPage.clickUserPage();
        usersPage.clickSurname();
        usersPage.clickButtonPencil();
        usersPage.clickDropDownList();
        usersPage.clickRoleAdministrator();
        usersPage.clickRoleDeveloper();
        usersPage.clickRoleManager();
        usersPage.clickRoleGeneralManager();
        usersPage.clickButtonSave();

    }

    @Тогда("^Пользователь убеждается в добавлении ролей пользователю$")
    public void userMakeSureAboutAddRoleToUser() {
        usersPage.checkMessageSuccess();
    }

    @Когда("^Пользователь создает задачу за вчерашний день редактирует ее и сохраняет$")
    public void userCreateTaskPastTimeAndEdit(Map<String, String> map) {
        trackerPage.clickBurgerMenu();
        trackerPage.ClickPageTimer();
        trackerPage.ClickButtonYesterday();
        trackerPage.sendInputTittle(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.clickAddTimeButton();
        trackerPage.clickTaskPastTime();
        trackerPage.sendTitlePastTime(map.get("Название"));


    }
}
