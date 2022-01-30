package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjectHomework.helpers.Attach;
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

        String userLogin = System.getProperty("user");
        String userPassword = System.getProperty("pass");
        String selenoidUrl = System.getProperty("remote");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://" + userLogin + ":" + userPassword + "@" + selenoidUrl;
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "1920x1080");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
