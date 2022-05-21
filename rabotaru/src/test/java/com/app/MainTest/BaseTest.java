package com.app.MainTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private Properties config = new Properties();
    protected String basePath;
    protected String testLogin;
    protected String testPassword;
    protected String vacancyPath;
    protected String careerPath;
    protected String companyPath;
    protected String searchData;


    @BeforeEach
    public void setup() throws IOException {
        String workingDir = System.getProperty("user.dir").replace("\\", "/");
        File dataSearchPath = new File(workingDir + "/src/test/resources/data/dataSearch.json");
        File dataSearchCompanyPath = new File(workingDir + "/src/test/resources/data/dataSearchCompany.csv");
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap map = objectMapper.readValue(dataSearchPath, HashMap.class);
        searchData = (String) map.get("searchData");

        InputStream inputStream = MainPageTest.class.getClassLoader().getResourceAsStream("env/application.yml");
        config.load(inputStream);
        basePath = config.getProperty("basePath");
        testLogin = config.getProperty("login");
        testPassword = config.getProperty("password");
        vacancyPath = config.getProperty("vacancyPath");
        careerPath = config.getProperty("careerPath");
        companyPath = config.getProperty("companyPath");

        Selenide.open(basePath);
        Configuration.browserSize = "1280x720";
        Configuration.pageLoadTimeout = 70000;
        Selenide.executeJavaScript("stop()");
    }
}