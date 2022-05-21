package com.app.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage extends MainPage {
    private final SelenideElement entranceButton = $(".user-profile-header__sign-in");
    private final SelenideElement loginInput = $("div.input-group:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    protected SelenideElement profileButton = $(".user-profile-header__element");

    public void auth(String login, String password) {
        entranceButton.click();
        loginInput.sendKeys(login);
        loginInput.sendKeys(Keys.ENTER);
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
    }

    public boolean izAuthorized() {
        return profileButton.isDisplayed();
    }

}