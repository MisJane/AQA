package com.app.MainTest;

import com.app.page.MainPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;


public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка, что на главной странице есть элемент логотип")
    void logoIsExistTest() {
        boolean logoDisplayed = mainPage.isLogoDisplayed();
        Assertions.assertTrue(logoDisplayed);
    }

    @Test
    @DisplayName("Проверка, что есть шапка сайта")
    void isHeaderItemsDisplay() {
        Assertions.assertTrue(mainPage.isHeaderExist(),
                "Ошибка: Нет заголовка сайта (header)");
    }

    @Test
    @DisplayName("Проверка значений шапки сайта")
    void headerItemsTextContain() {
        String headerItemsText = "Вакансии\nПрофессии\nКомпании\nБлог\nРаботодателю";
        String actualHeaderItems = mainPage.getHeaderItems();
        Assertions.assertEquals(headerItemsText, actualHeaderItems);
    }

    @Test
    @DisplayName("Проверка текста на странице")
    void checkText() {
        String testCheckText = "Поиск работы в Екатеринбурге";
        Assertions.assertTrue(mainPage.selectElementByText(testCheckText).exists(),
                "Ошибка: текст на странице не найден");
    }

}