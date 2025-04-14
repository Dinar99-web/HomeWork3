import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillTheFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Harry");
        $("#lastName").setValue("Potter");
        $("#userEmail").setValue("griffindor@rules.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9871335846");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1980");
        $$("div.react-datepicker__day").findBy(text("31")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Hogwarts");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $$("table tr").findBy(text("Student Name")).shouldHave(text("Harry Potter"));
        $$("table tr").findBy(text("Student Email")).shouldHave(text("griffindor@rules.com"));
        $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("table tr").findBy(text("Mobile")).shouldHave(text("9871335846"));
        $$("table tr").findBy(text("Date of Birth")).shouldHave(text("31 July,1980"));
        $$("table tr").findBy(text("Subjects")).shouldHave(text("English"));
        $$("table tr").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$("table tr").findBy(text("Picture")).shouldHave(text("test.jpg"));
        $$("table tr").findBy(text("Address")).shouldHave(text("Hogwarts"));
        $$("table tr").findBy(text("State and City")).shouldHave(text("Rajasthan Jaipur"));

        $("#closeLargeModal").click();
    }
}