
package stepdefs;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.*;
import pages.AutorizationPage;
import pages.UsersPage;
import com.codeborne.selenide.Selenide;

import java.util.List;
import java.util.Map;

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
        autorizationPage.sendInputEmail("nip@crtweb.ru");
        autorizationPage.clickNext();
        autorizationPage.sendInputPassword("nick2004");
        autorizationPage.clickNext();
        autorizationPage.switchWindow(0);
        Selenide.sleep(6000);//Обход авторизации гугла
    }

    @Когда("^Пользователь создает задачу с параметрами$")
    public void createTask(Map<String, String> map) {//тест проходит корректно при подключенном выпадающем списка(выбор проекта)
        trackerPage.sendNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get(" Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.setInputSelectProject(map.get("Проект"));
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

    @Тогда("^пользователь получает уведомление о неккорректной ссылке$")
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
        reportingPage.checkWrightResult();
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

    @Когда("^Пользователь создает успешно новый проект$")
    public void createNewTask(Map<String, String> map) {
        projectPage.clickBurgerMenu();
        projectPage.clickPageProject();
        projectPage.clickButtonPlusCreateProject();
        projectPage.sendInputTittleProject(map.get("Название проекта"));
        projectPage.sendInputDescribeProject(map.get("Описание"));
        projectPage.selectCurrentContractor(map.get("Подрядчик/Исполнитель"));
        projectPage.clickButtonCreateProject();
    }

    @Тогда("^Пользователь убеждается об успешном создании задачи$")
    public void userVerifySuccessTask() {
        trackerPage.verifyTask();
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
        autorizationPage.methodSwitchWindow();
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
        autorizationPage.methodSwitchWindow();
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
        contractorPage.verifyEditContract();
    }

    @Тогда("^Пользователь убеждается об успешном создании проекта$")
    public void userCheckSuccessCreateContract() {
        projectPage.checkSuccessProject();
    }

    @Когда("^Пользователь создает задачу с неполными параметрами$")
    public void createTaskWithoutProjectName(Map<String,String> map) {
        trackerPage.sendNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get(" Время начала"));
        trackerPage.setEndTime(map.get("Время конец"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.clickDescribeTask(map.get("Описание задачи"));
        trackerPage.AddTimeButton();
    }
}


