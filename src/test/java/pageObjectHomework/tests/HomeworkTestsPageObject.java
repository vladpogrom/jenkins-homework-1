package pageObjectHomework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class HomeworkTestsPageObject extends TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        dataComponent.dataComponentSet();
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Owner("vladpogrom")
    @DisplayName("Тесты на форму /practice-form")
    void fillForm() {
        step ("Открываем страницу", () -> {
            registrationPage.openForm();
        });
        step ("Заполняем дату и загружаем картинку", () -> {
            registrationPage.calendarComponent.setDate(TestData.userDateDay, TestData.userDateMonth, TestData.userDateYear);
            registrationPage.uploadFile();
        });
        step ("Заполняем остальные инпуты", () -> {
            registrationPage
                    .typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .typeUserEmail(data.userEmail)
                    .setGender(data.genderType)
                    .typeUserPhone(data.userNumber)
                    .typeCurrentAdress(data.userAdress)
                    .typeState(data.userState)
                    .typeCity(data.userCity)
                    .typeSubjects(data.subjects)
                    .typeHobbies(data.hobbies);
        });
        step ("Нажимаем сабмит и проверяем что форма проверки открыта", () -> {
            registrationPage.submitClick()
                    .checkResultValue(data.submitFormText);
        });
        step ("Делаем ассерты", () -> {
            registrationPage
                    .textCheckResultValue(data.firstName + " " + data.lastName)
                    .textCheckResultValue(data.userEmail)
                    .textCheckResultValue(String.join(", ", data.subjects))
                    .textCheckResultValue(String.join(", ", data.hobbies))
                    .textCheckResultValue(data.userNumber)
                    .textCheckResultValue(TestData.userPicture.substring(6))
                    .textCheckResultValue(data.userAdress)
                    .textCheckResultValue(data.userState + " " + data.userCity)
                    .textCheckResultValue(data.genderType)
                    .textCheckResultValue((TestData.userDateDay) + " " + (TestData.userDateMonthAssert) + "," + (TestData.userDateYear));
        });
        step ("Закрываем страницу и проверяем, что она закрыта", () -> {
            registrationPage.closeForm()
                    .isCloseFormClosed();
        });
    }

    @AfterEach
    public void saveSources() {
        registrationPage.attachPageSource();
    }
}