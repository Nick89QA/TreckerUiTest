package pages;

import com.codeborne.selenide.*;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AutorizationPage {
    private final SelenideElement auth = $x("//span[text()=' Авторизация']/parent::button");//авторизация
    private final SelenideElement mailInput = $("#identifierId");//поле input
    private final SelenideElement buttonNext = $x("//span[text()='Далее']");
    private final SelenideElement password = $("input[type='password']");//введение
    private final SelenideElement profileSettingsButton = $x("//button[@aria-label='account of current user']");
    private final SelenideElement verifyIncorrectEmail = $x("//div[text()='Введите адрес электронной почты или номер телефона.']");//проверка
    private final SelenideElement verifyIncorrectPassword = $x("//span[contains(text(), 'Неверный пароль')]");


    public void verifyAuth() {
        profileSettingsButton.shouldBe(Condition.enabled);
    }

    public void clickAuth() {
        auth.shouldBe(Condition.enabled).click();
    }

    public void setMailInput(String mail) {
        mailInput.shouldBe(Condition.enabled).setValue(mail);
    }

    public void setPassword(String password) {
        this.password.shouldBe(Condition.enabled).setValue(password);
    }

    public void clickNext() {
        buttonNext.shouldBe(Condition.enabled).click();
    }

    public void switchWindow(int num) {
        Selenide.switchTo().window(num);
    }

    public void sendIncorrectEmail(String email) {//метод посылает некоректный имейл
        auth.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();//клик на кнопку авторизация
        switchWindow(1);
        mailInput.shouldBe(Condition.enabled).setValue(email);//введение в поле некор имейла
        buttonNext.shouldBe(Condition.enabled).click();//клик на кнопку далее
    }

    public void verifyIncorrectEmail() {//проверка на некорректный имейл
        verifyIncorrectEmail.shouldBe(Condition.enabled).click();
    }

    public void sendIncorrectPassword(Map<String, String> map) {//метод посылает неккоректный пароль
        auth.shouldBe(Condition.enabled).click();
        switchWindow(1);
        mailInput.shouldBe(Condition.enabled).setValue(map.get("Корректный имейл"));//вводим корректный имейл
        buttonNext.shouldBe(Condition.enabled).click();//клик на кнопку далее
        password.shouldBe(Condition.enabled).setValue(map.get("Некорректный пароль"));//вводим некорректный пароль
        buttonNext.shouldBe(Condition.enabled).click();

    }

    public void incorrectPassword() {
        verifyIncorrectPassword.shouldBe(Condition.enabled);
    }
}


