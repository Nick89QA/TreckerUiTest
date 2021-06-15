package stepdefs;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import Pages.AutorizationPage;
import Pages.TrackerPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.util.Map;

public class TreckerTestSteps {
    private AutorizationPage autorizationPage = Selenide.page(AutorizationPage.class);
    private TrackerPage trackerPage = Selenide.page(TrackerPage.class);

    @Дано("^Пользователь авторизуется на сайте трекера$")
    public void openPage() {
     autorizationPage.clickAuth();
     autorizationPage.switchWindow(1);
     autorizationPage.setMailInput("nip@crtweb.ru");
     autorizationPage.clickNext();
     autorizationPage.setPassword("nick2004");
     autorizationPage.clickNext();
     autorizationPage.switchWindow(0);
    }

    @И("^Пользователь создает задачу с параметрами$")
    public void createTask(Map<String,String> map) {//входной параметр
        trackerPage.setNameInput(map.get("Название"));
        trackerPage.setStartTime(map.get("Время начала"));
        trackerPage.setEndTime(map.get("Время конец "));
        trackerPage.setProjectName(map.get("Проект"));
        trackerPage.setInputLink(map.get("Ссылка на задачу"));
        trackerPage.setDescription(map.get("Описание задачи"));
        trackerPage.clickAddTimeButton();
    }

    @Тогда("^задача создана коррректно$")
    public void werifyTask() {
     trackerPage.verifyTask();
    }
}

