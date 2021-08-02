package pages;

import com.codeborne.selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AutorizationPage {
    private final SelenideElement buttonAuth = $x("//span[text()=' Авторизация']");//авторизация
    private final SelenideElement inputEmail = $("#identifierId");//поле input
    private final SelenideElement buttonNext = $x("//span[text()='Далее']");
    private final SelenideElement inputPassword = $("input[type='password']");//введение
    private final SelenideElement verifyIncorrectEmail = $x("//div[text()='Введите адрес электронной почты или номер телефона.']");//проверка
    private final SelenideElement verifyIncorrectPassword = $x("//span[contains(text(), 'Неверный пароль')]");


    public void clickAuth() {
        buttonAuth
                .should(Condition.enabled).doubleClick();
    }

    public void sendInputEmail(String mail) {
        inputEmail
                .shouldBe(Condition.enabled).setValue(mail);
    }

    public void sendInputPassword(String inputPassword) {
        this.inputPassword
                .shouldBe(Condition.enabled)
                .setValue(inputPassword);
    }

    public void clickNext() {
        buttonNext
                .should(Condition.enabled)
                .scrollIntoView(true)
                .click();
    }


    public void verifyIncorrectEmail() {//проверка на некорректный имейл
        verifyIncorrectEmail
                .shouldBe(Condition.enabled).click();
    }

    public void incorrectPassword() {
        verifyIncorrectPassword
                .should(Condition.enabled);
    }

    public void clickButtonAuthorization() {
        buttonAuth
                .should(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void clickInputEmail(String email) {
        inputEmail.should(Condition.enabled)
                .setValue(email);//введение в поле некор имейла
    }

    public void clickButtonNext() {
        buttonNext
                .should(Condition.enabled).click();
    }

    public void sendInputIncorrectPassword(String incorrectPassword) {//fix
        inputPassword
                .should(Condition.enabled)
                .setValue(incorrectPassword);
    }
}


