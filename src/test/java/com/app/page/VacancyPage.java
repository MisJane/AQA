package com.app.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.restassured.RestAssured.given;

public class VacancyPage extends MainPage {
    private SelenideElement header = $x("//div[@class='home-vacancies__infinity-list']");
    private SelenideElement title = $(".vacancy-search__title");

    public String getHeader() {
        return header.getText();
    }
    public String getTitle() {
        return title.getText();
    }
}
