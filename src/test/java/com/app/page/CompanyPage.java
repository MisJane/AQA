package com.app.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CompanyPage {
    private ElementsCollection company = $$("div.company-card__left > h3");
    private SelenideElement searchInputCompany = $x("//*[contains(@class, 'company-search-form__field_name')]" +
            "//*[contains(@class, 'input-group__input')]/input");
    private SelenideElement searchButton = $x("//*[@aria-label='Найти']");
    private SelenideElement companies = $(".companies-list");

    public CompanyPage searchCompany(String value) {
        searchInputCompany.sendKeys(value);
        searchButton.click();
        companies.shouldBe(visible, Duration.ofSeconds(5));
        return new CompanyPage();
    }

    public List<String> getCareerTitles() {
        List<String> titlesText = new ArrayList<>();
        for (SelenideElement x : company) {
            titlesText.add(x.getText());
        }
        return titlesText;
    }
}