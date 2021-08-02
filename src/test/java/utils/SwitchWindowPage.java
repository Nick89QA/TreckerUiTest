package utils;

import com.codeborne.selenide.Selenide;

public class SwitchWindowPage {
    public void switchWindow(int num) {
        Selenide.switchTo()
                .window(num);
    }

}
