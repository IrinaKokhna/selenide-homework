package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class YouTubeResults {
    private ElementsCollection result = $$(".style-scope ytd-video-renderer");

    public void checkResults(String expected) {
        result.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(1)
                .shouldHave(Condition.text(expected));
    }
}
