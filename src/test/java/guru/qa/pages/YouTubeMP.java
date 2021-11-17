package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class YouTubeMP {

    public static final String URL = "https://www.youtube.com/";

    private static SelenideElement searchInput = $(byXpath("//div[@id='container']//input[@id='search']"));

    public YouTubeResults doSearch (String searchQuery) {
        searchInput.click();
        searchInput.setValue(searchQuery);
        searchInput.submit();
        return new YouTubeResults();
    }
}
