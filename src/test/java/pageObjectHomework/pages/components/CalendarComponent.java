package pageObjectHomework.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    static SelenideElement dateInputLocator = $("#dateOfBirthInput");
    static SelenideElement yearSelectLocator = $("[class*='year-select']");
    public SelenideElement monthSelectLocator = $("[class*='month-select']");
    public ElementsCollection daySelectLocator = $$("[role=option]");

    public void setDate(int day, int month, String year) {
        dateInputLocator.click();
        yearSelectLocator.selectOptionByValue(year);
        monthSelectLocator.selectOptionByValue(String.valueOf(month - 1));
        daySelectLocator.findBy(text(String.valueOf(day))).click();
    }
}

