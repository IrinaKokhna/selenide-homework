package guru.qa.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHub {
    @Test
    void selenide () {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //переходим по первой ссылке в гитхабе
        $$(".repo-list li").first().$(By.cssSelector("a")).click();
        //находим вкладку wiki и переходим по ней
        $("#repository-container-header > nav > ul > li:nth-child(6)").click();
        $(".markdown-body").shouldHave(text("Soft Assertions"));
        $(byText("Soft assertions")).click();
        $(byText("Example:")).scrollTo();
        //проверяем наличие примера кода для junit5
        $("#wiki-body :nth-child(17) > pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
