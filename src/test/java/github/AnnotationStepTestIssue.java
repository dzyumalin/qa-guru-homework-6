package github;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("safe2k19")

public class AnnotationStepTestIssue {
    private GithubSteps steps = new GithubSteps();

    @Test
    @Story("Создание Issues")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Тест на проверку искомого номера issue")
    public void testIssueAnnotatedSteps() {
        steps.openPage();
        steps.searchRepository("allure-framework/allure2");
        steps.goToRepository("allure-framework/allure2");
        steps.openIssue();
        steps.shouldSeeIssueWithNumber(1303);
    }
}
