
package stepdefs;

import io.cucumber.java.ru.Дано;
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


    @Дано("^Пользователь авторизуется на сайте трекера$")
    public void authorize() {
        autorizationPage.clickAuth();
        WebUtils.switchWindow(1);
        autorizationPage.sendInputEmail("nip@crtweb.ru");
        autorizationPage.clickNext();
        autorizationPage.sendInputPassword("nick2004");
        autorizationPage.clickNext();
        WebUtils.switchWindow(0);
        Selenide.sleep(6000);//Обход авторизации гугла
    }

    @Когда("^Пользователь создает задачу с параметрами$")
    public void createTask(Map<String, String> map) {//тест проходит корректно при подключенном выпадающем списка(выбор проекта)
        trackerPage.sendNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.AddTimeButton();

    }

    @Когда("^Пользователь создает задачу используя прошлый временной промежуток$")
    public void createTaskPastTime(Map<String, String> map) {
        trackerPage.clickBurgerMenu();
        trackerPage.ClickPageTimer();
        trackerPage.ClickButtonYesterday();
        trackerPage.sendNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLinkPastTime(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));//дописать задачу
        trackerPage.AddTimeButton();
    }

    @Когда("^Пользователь заходит на страницу с проектами$")
    public void userOnProjectPage() {
        trackerPage.clickMenuButton();//клик на меню
        projectPage.setMenuProject();//клик на страницу проекты
        projectPage.clickButtonAllProject();//клик на раздел "все проекты"
        projectPage.setButtonAlfaDirect();//клик на проект AльфаДирект
    }

    @Тогда("^задача создана корректно$")
    public void verifyTask() {
        trackerPage.verifyTask();
    }

    @Когда("^Пользователь переходит на страницу Пользователи$")
    public void goToUsersPage() {
        trackerPage.clickMenuButton();
        trackerPage.clickUserPage();//клик на юзерпейдж
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
        trackerPage.verifyProjectNotification();// проверка на обязательность выбора проекта
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
        projectPage.clickButtonArchive();
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
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).click();//клик на юзера
        Selenide.$x(String.format("//li[text()='%s']", map.get("Добавление пользователей"))).pressEscape();//нажатие на escape
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
    public void authorizationWithIncorrectEmail(String email) {//тест отра
        autorizationPage.clickButtonAuthorization();
        WebUtils.switchWindow(1);
        autorizationPage.clickInputEmail(email);
        autorizationPage.clickButtonNext();
    }

    @Тогда("^Пользователь убеждается об введении некорректного email$")
    public void userMakeSureIncorrectEmail() {
        autorizationPage.verifyIncorrectEmail();
    }

    @Когда("^Пользователь аторизуется в трекере используя некорректный пароль$")//тест отрабатывает корректно
    public void AuthorizeWithIncorrectPassword(Map<String, String> map) {
        autorizationPage.clickButtonAuthorization();
        WebUtils.switchWindow(1);
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
        contractorPage.scrollInputDeleteContract();//скрол на странице
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
        profilePage.clickButtonClickForExitFromCalendar();

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

    @Тогда("^Пользователь убеждается о досупном просмотре своей роли на странице Профиль$")
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
        trackerPage.sendNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.clickSelectProject(map.get("Проект"));
        trackerPage.setInputLinkPastTime(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));//дописать задачу
        trackerPage.AddTimeButton();
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
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectKnowledgeBase();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Лонгриды$")
    public void userRedirectFromMainPageToPagelongrid() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkLongread();
    }

    @Тогда("^Пользователь убеждается об успешном переходе на страницу Лонгриды$")
    public void userMakeSureSuccessRedirectPageLongrid() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectLongreadPage();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Платрум$")
    public void userRedirectFromMainPageToPagePlatrum() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkPlatrum();
    }

    @Тогда("^Пользователь убеждается об успешном переходе на страницу Платрум$")
    public void userMakeSureSuccessRedirectPagePlatrum() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectPlatrumPage();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Гит$")
    public void userRedirectFromMainPageToPageGit() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkGit();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Гит$")
    public void userMakeSureSuccessRedirectPageGit() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectGitPage();
    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу CRT.TEAM$")
    public void userRedirectFromMainPageToPageCrtTeam() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkCrtTeam();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу CRT.TEAM$")
    public void userMakeSureSuccessRedirectPageCrtTeam() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectCrtTeamPage();

    }

    @Когда("^Пользователь переходит с главной страницы трекера на страницу Сайт$")
    public void userRedirectFromMainPageToPageSite() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkSite();

    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Сайт$")
    public void userMakeSureSuccessRedirectPageSite() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectSitePage();
    }


    @Когда("^Пользователь переходит с главной страницы трекера на страницу Резюме специалистов$")
    public void userRedirectFromMainPageToPageResume() {
        trackerPage.clickButtonLink();
        trackerPage.clickLinkResume();
    }


    @Тогда("^Пользователь убеждается об успешном переходе на страницу Резюме специалистов$")
    public void userMakeSureSuccessRedirectPageResume() {
        WebUtils.switchWindow(1);
        trackerPage.verifySuccessRedirectSitePage();

    }

    @Когда("^Пользователь заполняет данные на странице Профиля$")
    public void userSetProfileSettings(Map<String, String> map) {
        profilePage.clickIconButton();
        profilePage.clickButtonProfile();
        profilePage.clickButtonEdit();
        profilePage.setProfilePageInputs(map);
        profilePage.clickButtonSave();
    }

    @Тогда("^Пользователь убеждется что данные профиля заполнились корректно$")
    public void verifyTextOnProfilePage(Map<String,String> map ) {
        Map<String,String> actualMap = profilePage.getProfileInfo();
        SoftAssert softAssert = new SoftAssert();
      for (String key:map.keySet()){
          softAssert.assertEquals(actualMap.get(key),map.get(key));
      }
     softAssert.assertAll();
    }


}


