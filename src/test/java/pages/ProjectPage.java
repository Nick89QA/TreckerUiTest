package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

 public class ProjectPage {
 private final SelenideElement menuProject = $x("//span[text()='Проекты']");//меню страница проекты
 private final SelenideElement buttonAllProject = $x("//span[text()='Все проекты']");//клик на раздел все проекты
 private final SelenideElement buttonAlfaDirect = $x ("//div[@data-panel='panel/api/projects/alfadirect']");//клик на проект альфадирект
 private final SelenideElement checkoutPageProject = $x("//div[@class='_3X1_X']");//проверка на странице проекты

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
}
