package pageObjectHomework.pages.registrationPage;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageObjectHomework.pages.components.CalendarComponent;
import pageObjectHomework.tests.TestData;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pageObjectHomework.tests.TestBase.URL;

public class RegistrationPage {

    public CalendarComponent calendarComponent = new CalendarComponent();

    // Locators
    private final SelenideElement genderLocator = $("#genterWrapper");
    private final SelenideElement firstNameLocator = $("#firstName");
    private final SelenideElement lastNameLocator = $("#lastName");
    private final SelenideElement userEmailLocator = $("#userEmail");
    private final SelenideElement userNumberLocator = $("#userNumber");
    private final SelenideElement resultTableElementLocator = $("[class=table-responsive]");
    private final SelenideElement submitButtonLocator = $("#submit");
    private final SelenideElement submitFormLocator = $("#example-modal-sizes-title-lg");
    private final SelenideElement practiceFormSelector = $(".practice-form-wrapper");
    private final SelenideElement closeFormLocator = $("#closeLargeModal");
    private final SelenideElement currentAdressLocator = $("#currentAddress");
    private final SelenideElement hobbyCheckboxLocator = $("#hobbiesWrapper");
    private final SelenideElement subjectsInputLocator = $("#subjectsInput");
    private final SelenideElement selectStateLocator = $("#react-select-3-input");
    private final SelenideElement selectCityLocator = $("#react-select-4-input");
    private final SelenideElement uploadPictureLocator = $("#uploadPicture");

    @Step("Открыть страницу {URL}")
    public RegistrationPage openForm() {
        open(URL);
        return this;
    }

    @Step("Проверить, что страница открыта")
    public RegistrationPage checkResultValue(String value) {
        submitFormLocator.shouldHave(text(value));
        return this;
    }

    @Step("Проверка наличия текста {value} на форме проверки")
    public RegistrationPage textCheckResultValue(String value) {
        resultTableElementLocator.shouldHave(text(value));
        return this;
    }

    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeFirstName(String value) {
        firstNameLocator.setValue(value);
        return this;
    }


    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeLastName(String value) {
        lastNameLocator.setValue(value);
        return this;
    }

    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeUserEmail(String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeUserPhone(String value) {
        userNumberLocator.setValue(value);
        return this;
    }

    @Step("Заполнить инпут значением {value}")
    public RegistrationPage typeCurrentAdress(String value) {
        currentAdressLocator.setValue(value);
        return this;
    }

    @Step("Заполнить поле state значением {value}")
    public RegistrationPage typeState(String value) {
        selectStateLocator.setValue(value).pressEnter();
        return this;
    }

    @Step("Заполнить поле city значением {value}")
    public RegistrationPage typeCity(String value) {
        selectCityLocator.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать радиобаттон гендера {value}")
    public RegistrationPage setGender(String value) {
        genderLocator.$(byText(value)).click();
        return this;
    }

    @Step("Нажать кнопку сабмита")
    public RegistrationPage submitClick() {
        submitButtonLocator.scrollTo().click();
        return this;
    }

    @Step("Закрыть форму проверки")
    public RegistrationPage closeForm() {
        closeFormLocator.scrollIntoView(false).click();
        return this;
    }

    @Step("Проверить, что форма проверки закрыта")
    public boolean isCloseFormClosed() {
        return closeFormLocator.isDisplayed(); // or shouldBe(visible)
    }

    @Step("Заполнить поле hobbies")
    public RegistrationPage typeHobbies(String[] hobbies) {
        Arrays.stream(hobbies).forEach(hobby -> hobbyCheckboxLocator.$(byText(hobby)).click());
        return this;
    }

    @Step("Заполнить поле subjects")
    public RegistrationPage typeSubjects(String[] subjects) {
        Arrays.stream(subjects).forEach(subject -> subjectsInputLocator.setValue(subject).pressEnter());
        return this;
    }

    public RegistrationPage uploadFile() {
        uploadPictureLocator.uploadFromClasspath(TestData.userPicture);
        return this;
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
