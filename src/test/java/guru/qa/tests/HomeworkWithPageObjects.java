package guru.qa.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import guru.qa.pages.RegistrationFormPages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.tests.TestData.*;

public class HomeworkWithPageObjects {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    public void scrolling(){
        $(byText("Hobbies")).scrollTo();
    }
    @Test
    void homeTest() {
        registrationFormPages.openPage();
        registrationFormPages.setName();
        registrationFormPages.setEmail();
        registrationFormPages.setCheckbox();
        registrationFormPages.setPhone();
        scrolling();
        registrationFormPages.calendarComponent.setDate("09","January","1990");
        registrationFormPages.setHobbies();
        registrationFormPages.uploadPic();
        registrationFormPages.setAddress();
        registrationFormPages.assertion();
    }
}
