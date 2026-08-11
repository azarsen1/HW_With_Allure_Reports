import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/");
    }

    @Step("Открываем поисковик")
    public void openSearchInput() {
        $(".octicon-search").click();
    }

    @Step("Активируем поле поисковика")
    public void clickSearchInput() {
        $(".TextInput-icon").click();
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo) {
        $("input[placeholder='Search or jump to...']")
                .setValue(repo)
                .pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepository(String repo) {
        $("a[href=\"/azarsen1/HW_With_Allure_Reports\"]").click();
    }

    @Step("Кликаем по табу issues ")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие текста \"No results\" ")
    public void shouldSeeTextWhenIsNotIssues(String value) {
        $(".blankslate-heading").shouldHave(text("No results"));
    }

}
