package pageObjectHomework.tests;

import pageObjectHomework.pages.components.DataComponent;
import pageObjectHomework.pages.registrationPage.RegistrationPage;

public class TestBase {

    public static DataComponent dataComponent = new DataComponent();
    public static RegistrationPage registrationPage = new RegistrationPage();
    public TestData data = new TestData();
    public static String URL = "https://demoqa.com/automation-practice-form";
}
