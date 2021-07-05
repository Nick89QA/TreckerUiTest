
package stepdefs;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.*;
import pages.AutorizationPage;
import pages.UsersPage;
import com.codeborne.selenide.Selenide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.text;

public class TrackerTestSteps {
    private AutorizationPage autorizationPage = Selenide.page(AutorizationPage.class);
    private TrackerPage trackerPage = Selenide.page(TrackerPage.class);
    private UsersPage usersPage = Selenide.page(UsersPage.class);
    private ProjectPage projectPage = Selenide.page(ProjectPage.class);
    private ContractorPage contractorPage = Selenide.page(ContractorPage.class);
    private ReportingPage reportingPage = Selenide.page(ReportingPage.class);

    @Дано("^Пользователь авторизуется на сайте трекера$")
    public void authorize() {
        autorizationPage.clickAuth();
        autorizationPage.switchWindow(1);
        autorizationPage.setMailInput("nip@crtweb.ru");
        autorizationPage.clickNext();
        autorizationPage.setPassword("nick2004");
        autorizationPage.clickNext();
        autorizationPage.switchWindow(0);
    }

    @Когда("^Пользователь создает задачу с параметрами$")
    public void createTask(Map<String, String> map) {//входной параметр
        trackerPage.createTask(map);
    }

    @Тогда("^задача создана корректно$")
    public void verifyTask() {
        trackerPage.verifyTask();
    }

    @Тогда("^авторизация прошла успешно$")
    public void verifyAuth() {
        autorizationPage.verifyAuth();
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

    @Тогда("^пользователь получает уведомление о неккорректной ссылке$")
    public void verifyErrorNotification() {
        trackerPage.verifyErrorNotification();
    }

    @Тогда("^пользователь получает уведомление о необходимости выбора проекта$")
    public void verifyProjectNotification() {
        trackerPage.verifyProjectNotification();// проверка на обязательность выбора проекта
    }

    @Когда("^Пользователь заходит на страницу с проектами$")
    public void userOnProjectPage() {
        trackerPage.clickMenuButton();//клик на меню
        projectPage.setMenuProject();//клик на страницу проекты
        projectPage.setButtonAllProject();//клик на раздел "все проекты"
        projectPage.setButtonAlfaDirect();//клик на проект AльфаДирект
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
        contractorPage.reviewContractPage();
    }

    @Тогда("^Пользователь убеждается о доступности подрядчиков на странице$")
    public void checkAvailableContractPage() {
        contractorPage.checkContractPage();
    }

    @Когда("^Пользователь заходит на страницу отчетности$")
    public void userGoToReportingPage() {
        reportingPage.userOnReportPage();
    }

    @Тогда("^Пользователь убеждается о доступности отчетности за прошлый месяц$")
    public void verifyReports() {
        reportingPage.checkWrightResult();
    }

    @Когда("^Пользователь добавляет свой проект в архив$")
    public void userAddProjectToArchive() {
        projectPage.addProjectToArchive();
    }

    @Тогда("^Пользователь убеждается об успешном добавлении проекта в архив$")
    public void checkToaddingProject() {
        projectPage.verifyArchive();
    }

    @Когда("^Пользователь создает подряд на странице с подрядами$")
    public void userCreateNewContract(Map<String, String> map) {
        contractorPage.createContract(map);
    }

    @Когда("^Пользователь создает успешно новый проект$")
    public void createNewTask(Map<String, String> map) {
        projectPage.createProject(map);
    }

    @Когда("^Пользователь создает задачу используя прошлый временной промежуток$")
    public void createTaskPastTime(Map<String, String> map) {
        trackerPage.taskPastTime(map);
    }

    @Тогда("^Пользователь убеждается об успешном создании задачи$")
    public void userVerifySuccessTask() {
        trackerPage.verifyTask();
    }

    @Когда("^Пользователь заходит на страницу Пользователя и ищет свою фамилию$")
    public void userGoToUserPage(Map<String, String> map) {
        usersPage.searchSurname(map);
    }

    @Тогда("^Пользователь убеждается об успешном нахождении данной фамилии$")
    public void userVerifyResult() {
        usersPage.verifyResult();
    }

    @Когда("^Пользователь заходит в свой проект и добавляет туда менеджера$")
    public void userAddManagerToProject(Map<String, String> map) {
        projectPage.addManagerToProject(map);
    }

    @Тогда("^Пользователь убеждается об успешном добавлении менеджера в свой проект$")
    public void verifyAddingManager() {
        projectPage.verifyAddManager();
    }

    @Когда("^Пользователь заходит на страницу с проектами AlfaDirect и открывает отчет за прошлый месяц$")
    public void reviewReportForLastMonth() {
        projectPage.ReviewReport();
    }

    @Тогда("^Пользователь убеждается об успешном просмотре отчета по проекту$")
    public void verifySuccessReport() {
        projectPage.checkReport();
    }

    @Когда("^Пользователь авторизуется в трекере используя некорректный email '(.*)'$")
    public void authorizationWithIncorrectEmail(String email) {
        autorizationPage.sendIncorrectEmail(email);
    }

    @Тогда("^Пользователь убеждается об введении некорректного email$")
    public void userMakeSureIncorrectEmail() {
        autorizationPage.verifyIncorrectEmail();

    }

    @Когда("^Пользователь аторизуется в трекере используя некорректный пароль$")
    public void AuthorizeWithIncorrectPassword(Map<String, String> map) {
        autorizationPage.sendIncorrectPassword(map);
    }

    @Тогда("^Пользователь убеждается об введении некорректного пароля$")
    public void userVerifyIncorrectPassword() {
        autorizationPage.incorrectPassword();
    }

    @Когда("^Пользователь заходит на страницу с подрядами и удаляет подряд$")
    public void DeleteContract() {
        contractorPage.userDeleteContract();
    }


    @Тогда("^Пользователь убеждается об успешном удалении подряда$")
    public void verifyDeleteContract() {
        contractorPage.verifyDeleteContract();
    }

    @Когда("^Пользователь редактирует информацию о подрядчике$")
    public void userCanEditContract(Map<String, String> map) {
        contractorPage.userEditContract(map);
    }

    @Тогда("^Пользователь убеждается об успешном редактировании информации о подрядчике$")
    public void verifySuccessEdit() {
        contractorPage.verifyEditContract();
    }
}


