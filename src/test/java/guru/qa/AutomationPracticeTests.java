package guru.qa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeTests {
    @BeforeAll
    static void openBrowser() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void automationPracticeTest() {
        $("#firstName").setValue("John");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("john.smith@mail.com");
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").setValue("8912345678");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Che").pressEnter();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $x("//label[contains(text(),'Reading')]").click();
        $("#uploadPicture").uploadFile(new File("src/kitten.png"));
        $("#currentAddress").setValue("Test Address");
        $("#state").scrollTo();
        $x("//*[@id='state']/div/div[2]/div").click();
        $x("//div[text()='Uttar Pradesh']").click();
        $x("//*[@id='city']/div/div[2]/div").click();
        $x("//div[text()='Agra']").click();

        $("#submit").click();

        $(".modal-header").shouldBe(visible).shouldHave(text("Thanks for submitting the form"));

        $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text("John Smith"));
        $x("//tr[td[text()='Student Email']]/td[2]").shouldHave(text("john.smith@mail.com"));
        $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text("Male"));
        $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text("8912345678"));
        $x("//tr[td[text()='Date of Birth']]/td[2]").shouldHave(text("10 April,1990"));
        $x("//tr[td[text()='Subjects']]/td[2]").shouldHave(text("Chemistry, Maths"));
        $x("//tr[td[text()='Hobbies']]/td[2]").shouldHave(text("Sports, Reading"));
        $x("//tr[td[text()='Picture']]/td[2]").shouldHave(text("kitten.png"));
        $x("//tr[td[text()='State and City']]/td[2]").shouldHave(text("Uttar Pradesh Agra"));
    }
}
