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
    @DisplayName("��������, ��� �� ������� �������� ���� ������� �������")
    void logoIsExistTest() {
        boolean logoDisplayed = mainPage.isLogoDisplayed();
        Assertions.assertTrue(logoDisplayed);
    }

    @Test
    @DisplayName("��������, ��� ���� ����� �����")
    void isHeaderItemsDisplay() {
        Assertions.assertTrue(mainPage.isHeaderExist(),
                "������: ��� ��������� ����� (header)");
    }

    @Test
    @DisplayName("�������� �������� ����� �����")
    void headerItemsTextContain() {
        String headerItemsText = "��������\n���������\n��������\n����\n������������";
        String actualHeaderItems = mainPage.getHeaderItems();
        Assertions.assertEquals(headerItemsText, actualHeaderItems);
    }

    @Test
    @DisplayName("�������� ������ �� ��������")
    void checkText() {
        String testCheckText = "����� ������ � �������������";
        Assertions.assertTrue(mainPage.selectElementByText(testCheckText).exists(),
                "������: ����� �� �������� �� ������");
    }

}