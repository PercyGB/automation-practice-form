package tests;

import com.codeborne.selenide.Configuration;
import helpers.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends Config {

    @Test
    void successfullFormSubmitTest(){
        open("https://demoqa.com/automation-practice-form");

        // Fill Form
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("john.doe@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9081231234");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Tuesday, January 1st, 1991']").click();

        $("#subjectsInput").setValue("Co").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("./src/test/resources/john-doe-photo.jpg"));
        $("#currentAddress").setValue("Washington, DC");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $(byText("Delhi")).click();

        // Submit Form
        $("#submit").click();

        //Check Data
        $(".table-responsive").shouldHave(
                text("John Doe"),
                text("john.doe@gmail.com"),
                text("Male"),
                text("9081231234"),
                text("01 January,1991"),
                text("Computer Science"),
                text("Reading"),
                text("john-doe-photo.jpg"),
                text("Washington, DC"),
                text("NCR Delhi"));
    }
}
