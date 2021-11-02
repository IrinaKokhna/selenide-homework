package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://www.youtube.com/");
    }
    @Step("Ищем поисковую строку")
    public void searchForLine() {
        $(byXpath("//div[@id='container']//input[@id='search']")).click();
    }
    @Step("Поиск результатов по запросу")
    public void searchForResult() {
        $(byXpath("//div[@id='container']//input[@id='search']")).sendKeys("katy perry");
        $(byXpath("//div[@id='container']//input[@id='search']")).submit();
    }
    @Step("Ищем текст на странице с реузльтатами")
    public void ensureResult() {
        $(byText("pop icon puts her life")).should(Condition.visible);
    }
}
