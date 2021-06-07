package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SimpleSelenideTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "allure-framework/allure2";
    private static final int ISSUE_NUMBER = 1303;

    @Test
    public void selenideTestIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText("allure-framework/allure2")).click();
        $(withText("Issues")).click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
    }

    @Test
    public void lambdaTestIssue() {
        step("Открываем главную страницу", (s) -> {
            s.parameter("URL", BASE_URL);
            open(BASE_URL);
        });

        step("Ищем репозиторий" + REPOSITORY, (s) -> {
            s.parameter("Repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий" + REPOSITORY, (s) -> {
            s.parameter("Repository", REPOSITORY);
            $(By.linkText("allure-framework/allure2")).click();
        });

        step("Открываем таб Issues в репозитории", () -> {
            $(withText("Issues")).click();
        });

        step("Проверяем Issue с номером " + ISSUE_NUMBER + " существует", (s) -> {
            s.parameter("Number", ISSUE_NUMBER);
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
