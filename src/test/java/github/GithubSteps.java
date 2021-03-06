package github;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps {

    @Step("Открываем страницу")
    public void openPage() {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).submit();
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(By.linkText(repository)).click();
    }
    @Step("Открываем таб Issues в репозитории")
    public void openIssue() {
        $(withText("Issues")).click();
    }
    @Step("Проверяем, что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(visible);
    }
}
