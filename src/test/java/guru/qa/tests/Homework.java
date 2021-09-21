package guru.qa.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Homework {
    @Test
    void homeTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Krbtv");
        $("#userEmail").setValue("krbtvir@mail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("8005553535");
        $(byText("Hobbies")).scrollTo();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--009:not(react-datepicker__day--009 react-datepicker__day--outside-month)").click();
        $(By.xpath("//*[@id=\"subjectsInput\"]")).setValue("Maths").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/screen/Screenshot 2021-09-02 at 12.26.43.png"));
        $(By.xpath("//*[@id=\"currentAddress\"]")).setValue("addressless");
        $(By.xpath("//*[@id=\"state\"]/div/div[2]")).click();
        $(byText("NCR")).click();
        $(By.xpath("//*[@id=\"city\"]/div/div[2]")).click();
        $(byText("Delhi")).click();
        $(By.xpath("//*[@id=\"submit\"]")).click();
        $(".table-responsive").shouldHave(text("Irina Krbtv"), text("krbtvir@mail.com"),
                text ("Screenshot 2021-09-02 at 12.26.43.png"), text("Maths"), text("NCR Delhi"));
    }
}
