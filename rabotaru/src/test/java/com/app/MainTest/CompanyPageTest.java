package com.app.MainTest;

import com.app.page.CompanyPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


public class CompanyPageTest extends BaseTest {
    @BeforeEach
    void openPath() {
        Selenide.open(companyPath);
    }


    @ParameterizedTest
    @Description("Параметризированный тест для поиска разных компаний")
    @CsvSource({"PIZZA, Pizza", "IT, IT"})
    void searchCompanyTest(String inputValue, String resultValue){
        CompanyPage companyPage = new CompanyPage();
        String searchCompanyResult = String.valueOf(companyPage.searchCompany(inputValue).getCareerTitles());
        Assertions.assertTrue(searchCompanyResult.contains(resultValue));
    }

    @ParameterizedTest
    @Description("Параметризированный тест для поиска разных компаний. Данные из scv файла")
    @CsvFileSource(files = {"C:\\PROJects\\Java\\Main\\src\\test\\resources\\data\\dataSearchCompany.csv"})
    void searchCompanyTestFromFile(String inputValue, String resultValue){
        CompanyPage companyPage = new CompanyPage();
        String searchCompanyResult = String.valueOf(companyPage.searchCompany(inputValue).getCareerTitles());
        Assertions.assertTrue(searchCompanyResult.contains(resultValue));
    }

}
