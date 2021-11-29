package guru.qa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SampleLambda {
    @Test
    public void sampleTest() {
        step("Открываем главную страницу", () -> {
            open("https://www.youtube.com/");
        });
        step("Ищем поисковую строку", () -> {
            $(byXpath("//div[@id='container']//input[@id='search']")).click();
        });
        step("Поиск результатов по запросу", () -> {
            $(byXpath("//div[@id='container']//input[@id='search']")).sendKeys("katy perry");
            $(byXpath("//div[@id='container']//input[@id='search111']")).submit();
        });
        step("Ищем текст на странице с реузльтатами", () -> {
            $(byText("pop icon puts her life")).should(Condition.visible);
        });
    }
}