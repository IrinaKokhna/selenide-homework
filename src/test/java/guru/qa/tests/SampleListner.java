package guru.qa.tests;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleListner {
    @Test
    public void sampleTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://www.youtube.com/");
        $(byXpath("//div[@id='container']//input[@id='search']")).as("Search line").click();
        $(byXpath("//div[@id='container']//input[@id='search']")).as("Fill katy perry").
                sendKeys("katy perry");
        $(byXpath("//div[@id='container']//input[@id='search']")).as("Press Enter").submit();
        $(byText("pop icon puts her life")).as("Search").should(Condition.visible);
    }
}