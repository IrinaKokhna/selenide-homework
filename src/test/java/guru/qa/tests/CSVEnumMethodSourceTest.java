package guru.qa.tests;

import guru.qa.domain.MenuItem;
import guru.qa.pages.YouTubeMP;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class CSVEnumMethodSourceTest {

    static Stream<Arguments> menuItemsTestWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        1, "Hello", new ArrayList<>()
                ),
                Arguments.of(
                        2, "world", new ArrayList<>()
                )
        );
    }

    @MethodSource

    @ParameterizedTest(name = "{1}")
    void menuItemsTestWithMethodSource (int i, String str, List List) {
        open(YouTubeMP.URL);
        new YouTubeMP().doSearch(str).checkResults(str);
    }
    @EnumSource(MenuItem.class)

    @ParameterizedTest(name = "{1}")
    void menuItemsTest (MenuItem menuItem) {
        open(YouTubeMP.URL);
        new YouTubeMP().doSearch("tommy cash")
                .switchToMenuItem(menuItem);
        System.out.println();
    }


    @CsvSource({
            "3, tommy cash, very complex name",
            "7, rezz, very complex name"
    })

    @ParameterizedTest(name = "{1}")
    void complexNameTest (int lovelyMusicians, String searchQuery, String testName) {
        open(YouTubeMP.URL);
        new YouTubeMP().doSearch(searchQuery).checkResults(searchQuery);
    }

}
