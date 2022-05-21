package com.app.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement searchInput = $(".vacancy-search-form-smart__item .input-group__input > input");
    private final SelenideElement logo = $(".page-header__left-logo .r-logo > img");
    private final SelenideElement header = $("header");
    private final SelenideElement headerItems = $(".tabs__container");
    private final SelenideElement enterButton = $x("//*[@aria-label='Создать резюме']");

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
    public boolean isHeaderExist(){
        return header.exists();
    }

    public VacancyPage searchVacancy(String value){
        searchInput.sendKeys(value);
        searchInput.sendKeys(Keys.ENTER);
        return new VacancyPage();
    }

    public SelenideElement selectElementByText(String text) {
        return $(byText(text));
    }

    public String getHeaderItems() {
        return headerItems.getText();
    }

    public SelenideElement getEnterButton() {
        return enterButton;
    }


}
