package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import guru.qa.domain.MenuItem;

import static com.codeborne.selenide.Selenide.$$;

public class YouTubeResults {
    private ElementsCollection result = $$(".style-scope ytd-video-renderer");

    public void checkResults(String expected) {
        result.shouldBe(CollectionCondition.sizeGreaterThan(0)).get(1)
                .shouldHave(Condition.text(expected));
    }

    public YouTubeResults switchToMenuItem(MenuItem menuItem) {
        if (menuItem == MenuItem.LIBRARY)
            Selenide.$$("tp-yt-paper-item[role='tab']")
                    .find(Condition.text(menuItem.getDesc()))
                    .click();
        else if (menuItem == MenuItem.HISTORY)
            Selenide.$$("tp-yt-paper-item[role='tab']")
                    .find(Condition.text(menuItem.getDesc()))
                    .click();
        else throw new IllegalArgumentException("This enum is not supported");

        return this;
    }
}
