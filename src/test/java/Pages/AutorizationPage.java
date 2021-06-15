package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AutorizationPage {
    private final SelenideElement auth = Selenide.$("#root > div > div > button > span.MuiButton-label");//авторизация
    private final SelenideElement mailInput = Selenide.$("#identifierId");//поле input
    private final SelenideElement buttonNext = Selenide.$x("//span[text()='Далее']");
    private final SelenideElement password = Selenide.$("input[type='password']");//введение

    public void clickAuth() {
        auth.shouldBe(Condition.enabled).click();
    }
    public void setMailInput(String mail) {
        mailInput.shouldBe(Condition.enabled).setValue(mail);
    }
    public void setPassword(String password) {
        this.password.shouldBe(Condition.enabled).setValue(password);
    }
    public void clickNext(){
        buttonNext.shouldBe(Condition.enabled).click();
    }
    public void switchWindow(int num) {
        Selenide.switchTo().window(num);
    }
}

