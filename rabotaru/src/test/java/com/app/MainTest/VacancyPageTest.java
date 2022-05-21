package com.app.MainTest;

import com.app.page.MainPage;
import com.app.page.VacancyPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

public class VacancyPageTest extends BaseTest {
    @BeforeEach
    void openPath() {
        Selenide.open(vacancyPath);
    }

    @Test
    @DisplayName("Поиск вакансии из data-файла, проверка, что в результате есть нужная вакансия")
    void searchVacancyTest() {
        MainPage mainPage = new MainPage();
        String vacancyFromPage = mainPage
                .searchVacancy(searchData)
                .getHeader();
        Assertions.assertTrue(vacancyFromPage.contains(searchData));
    }

    @Test
    @DisplayName("Смена локации")
    @Description("Используем JavaScript")
    void replaceLocation() {
        VacancyPage vacancyPage = new VacancyPage();
        Selenide.executeJavaScript("window.location.replace('https://eburg.rabota.ru/')");
        Assertions.assertNotEquals(vacancyPage.getTitle(), "Свежие вакансии в Екатеринбурге");
    }

}
