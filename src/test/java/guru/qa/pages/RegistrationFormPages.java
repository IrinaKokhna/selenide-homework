package guru.qa.pages;

import guru.qa.pages.components.CalendarComponent;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.tests.TestData.*;

public class RegistrationFormPages {
    public CalendarComponent calendarComponent = new CalendarComponent();


    public void openPage() {

        open("https://demoqa.com/automation-practice-form");
    }

    public void setFirstName(String firstName){
        $("#firstName").setValue(firstName);
    }
    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }
    public void setEmail() {
        $("#userEmail").setValue(userEmail);
    }
    public void setCheckbox() {
        $(byText("Female")).click();
    }
    public void setPhone() {
        $("#userNumber").setValue(phone_number);
    }
    public void setHobbies() {
        $(By.xpath("//*[@id=\"subjectsInput\"]")).setValue("Maths").pressEnter();
        $(byText("Music")).click();
    }
    public void uploadPic() {
        $("#uploadPicture").uploadFile(new File("src/test/resources/screen/Screenshot 2021-09-02 at 12.26.43.png"));
    }
    public void setAddress() {
        $(By.xpath("//*[@id=\"currentAddress\"]")).setValue(currentAddress);
        $(By.xpath("//*[@id=\"state\"]/div/div[2]")).click();
        $(byText("NCR")).click();
        $(By.xpath("//*[@id=\"city\"]/div/div[2]")).click();
        $(byText("Delhi")).click();
        $(By.xpath("//*[@id=\"submit\"]")).click();
    }
    public void assertion() {
        $(".table-responsive").shouldHave(text(first_name + " " + last_name), text(userEmail),
                text ("Screenshot 2021-09-02 at 12.26.43.png"), text("Maths"), text("NCR Delhi"));
    }
}
