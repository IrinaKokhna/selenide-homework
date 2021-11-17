package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.YouTubeMP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

public class AnnotatedParallelTest {
    @ValueSource(strings = {
            "katy perry",
            "tommy cash",
            "justin bieber",
            "rezz"
    })

    @Execution(value = ExecutionMode.SAME_THREAD)
    @ParameterizedTest
    void youtubeSearch(String searchQuery, TestInfo testInfo) {
        Configuration.browser = "firefox";
        open(YouTubeMP.URL);
        new YouTubeMP().doSearch(searchQuery).checkResults(searchQuery);
        System.out.println("Config for another browser: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.browser);
    }

    @ResourceLock("config=chrome")
    @DisplayName("Rezz test in another browser")
    @Test
    void anotherBrowserSearch (TestInfo testInfo) {
        Configuration.browser = "chrome";
        open(YouTubeMP.URL);
        new YouTubeMP().doSearch("Rezz").checkResults("Rezz");
        System.out.println("Config for another browser: "
                + testInfo.getDisplayName()
                + " "
                + Configuration.browser);
    }
}
