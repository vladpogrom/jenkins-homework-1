package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjectHomework.pages.components.DataComponent;
import pageObjectHomework.pages.registrationPage.RegistrationPage;

public class TestBase {

    public static DataComponent dataComponent = new DataComponent();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public static String URL = "https://demoqa.com/automation-practice-form";
    public TestData data = new TestData();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        dataComponent.dataComponentSet();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
