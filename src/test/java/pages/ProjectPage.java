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
    private final SelenideElement clickInputPerformer = $x("(//div[@role='button'])[5]");//клик на поле подрядчик
    private final SelenideElement checkoutCreateProject = $x("(//div[@class='MuiAccordionSummary-content'])[3]");//проверка созданного проекта
    private final SelenideElement burgerMenu = $x("(//button[@type='button'])[1]");//клик на меню


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

    //создаем метод с параметрами для создания проекта
    public void createProject(Map<String,String>map ) {
        burgerMenu.shouldBe(Condition.enabled).click();
        menuProject.shouldBe(Condition.enabled).click();//меню проекта
        buttonCreateProject.shouldBe(Condition.enabled).click();//клик на плюсик создание проекта
        inputTittleProject.shouldBe(Condition.enabled).setValue(map.get("Название проекта"));
        inputDescribeProject.shouldBe(Condition.enabled).setValue(map.get("Описание"));
        clickInputPerformer.shouldBe(Condition.enabled).click();
        Selenide.$x(String.format("//li[text()='%s']",map.get("Подрядчик/Исполнитель"))).click();//любое значение передаем
        createProjectButton.shouldBe(Condition.enabled).click();
        Selenide.$x(String.format("//p[text()='%s']",map.get("Название проекта"))).shouldBe(Condition.appear);//
    }
   public void checkNewProject() {//метод проверяет задачу с названием проекта в списке
    checkoutCreateProject.shouldBe(Condition.appear);
   }
}
