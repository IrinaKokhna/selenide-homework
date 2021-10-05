package guru.qa.tests;

import guru.qa.pages.RegistrationFormPages;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static guru.qa.tests.TestData.*;

public class HomeworkWithPageObjects {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    public void scrolling(){
        $(byText("Hobbies")).scrollTo();
    }
    @Test
    void homeTest() {
        registrationFormPages.openPage();
        registrationFormPages.setFirstName(first_name);
        registrationFormPages.setLastName(last_name);
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
