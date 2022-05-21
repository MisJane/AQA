package com.app.MainTest;

import com.app.page.AuthorizationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorizationTest extends BaseTest{

    @Test
    @DisplayName("����������� �� �����, ��������, ��� ���� ������ ��������")
    void authorizationTest(){
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.auth(testLogin, testPassword);
        boolean isAuthed = authorizationPage.izAuthorized();
        Assertions.assertTrue(isAuthed, "������: ������ �������� ���������");
    }

}
