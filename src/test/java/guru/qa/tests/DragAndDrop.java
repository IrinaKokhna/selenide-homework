package guru.qa.tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").dragAndDropTo($("#column-a"));
        $("#column-a").shouldHave(text("B"));
    }
}
