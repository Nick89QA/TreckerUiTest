
package stepdefs;

import pages.AutorizationPage;
import pages.ProjectPage;
import pages.TrackerPage;
import pages.UsersPage;
import com.codeborne.selenide.Selenide;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.text;

public class TrackerTestSteps {
    private AutorizationPage autorizationPage = Selenide.page(AutorizationPage.class);
    private TrackerPage trackerPage = Selenide.page(TrackerPage.class);
    private UsersPage usersPage = Selenide.page(UsersPage.class);
    private ProjectPage projectPage = Selenide.page(ProjectPage.class);

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

    @Когда("^Пользователь создает задачу с (параметрами|некорректными параметрами)$")
//дополняем в скобках название сценария
    public void newTask (String s, Map<String, String> map) {//входной параметр
        trackerPage.createTask(map);
        }

    @Тогда("^задача создана корректно$")
    public void verifyTask() {
        trackerPage.verifyTask();
    }

        @Тогда("^авторизация прошла успешно$")
        public void verifyAuth () {
            autorizationPage.verifyAuth();
        }

        @Когда("^Пользователь переходит на страницу Пользователи$")
        public void goToUsersPage () {
            trackerPage.clickMenuButton();
            trackerPage.clickUserPage();//клик на юзерпейдж
        }

        @И("^Вводит в поле поиска (.*)$")
        public void writeTextSearchField (String text){
            usersPage.setSearchField(text);//вводим текст в searchField
        }

        @Тогда("^результат поиска содержит (.*)$")
        public void searchResult (String text){
            usersPage.verifySearch(text);
        }

        @Тогда("^пользователь ищет по параметрам и убеждается в успехе$")
        public void verifySuccessSearch (List < String > textList) {
            for (String s : textList) {
                usersPage.setSearchField(s);
                usersPage.verifySearch(s);
            }
        }

        @Тогда("^пользователь получает уведомление о неккорректной ссылке$")
        public void verifyErrorNotification () {
            trackerPage.verifyErrorNotification();
        }
//        @Когда("^Пользователь создает задачу без проекта$")//дополняем в скобках название сценария
//        public void taskWithoutProject (Map < String, String > map){//входной параметр
//            trackerPage.createTask(map);
//        }
        @Тогда("^пользователь получает уведомление о необходимости выбора проекта$")
        public void verifyProjectNotification () {
            trackerPage.verifyProjectNotification();// проверка на обязательность выбора проекта

        }
        @Когда("^Пользователь заходит на страницу с проектами$")
        public void userOnProjectPage () {
            trackerPage.clickMenuButton();//клик на меню
            projectPage.setMenuProject();//клик на страницу проекты
            projectPage.setButtonAllProject();//клик на раздел "все проекты"
            projectPage.setButtonAlfaDirect();//клик на проект AльфаДирект
        }
        @Тогда("^Пользователь может просматривать информацию о проекте$")
        public void verifyProjectPage () {
            projectPage.setCheckoutPageProject();
        }

    }

