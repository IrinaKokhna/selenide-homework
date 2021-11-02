package guru.qa.tests;


import org.junit.jupiter.api.Test;

public class SampleAnnotatedStep {
    @Test
    public void sampleTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForLine();
        steps.searchForResult();
        steps.ensureResult();
    }
}