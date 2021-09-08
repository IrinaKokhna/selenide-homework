package guru.qa.tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class homework {
    @Test
    void homeTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Irina");
        $("#lastName").setValue("Krbtv");
        $("#userEmail").setValue("krbtvir@mail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("8005553535");
        $(byText("Current Address")).scrollTo();
        $("#dateOfBirthInput").click();
        $(By.xpath("//div[2]//div[2]/div[2]/div[1]/form/div[5]//div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")).click();
        $(By.xpath("//div[2]//div[2]/div[2]/div[1]/form/div[5]//div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[91]")).click();
        $(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")).click();
        $(By.xpath("//*[@id=\"subjectsInput\"]")).setValue("Maths").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/screen/Screenshot 2021-09-02 at 12.26.43.png"));
        $(By.xpath("//*[@id=\"currentAddress\"]")).setValue("addressless");
        $(By.xpath("//*[@id=\"state\"]/div/div[2]")).click();
        $(byText("NCR")).click();
        $(By.xpath("//*[@id=\"city\"]/div/div[2]")).click();
        $(byText("Delhi")).click();
        $(By.xpath("//*[@id=\"submit\"]")).click();
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).shouldHave(text("Irina Krbtv"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).shouldHave(text("krbtvir@mail.com"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).shouldHave(text("Female"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).shouldHave(text("8005553535"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).shouldHave(text("29 August,1990"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).shouldHave(text("Maths"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).shouldHave(text("Music"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")).shouldHave(text("Screenshot 2021-09-02 at 12.26.43.png"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).shouldHave(text("addressless"));
        $(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).shouldHave(text("NCR Delhi"));
    }
}
