import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class StepsTest extends TestBase {
    private static final String REPOSITORY = "azarsen1/HW_With_Allure_Reports";

    @Test
    public void testLambdaStep() {


        step("Открываем главную страницу", () -> {
        open("/");
        });
        step("Открываем поисковик", () -> {
        $(".octicon-search").click();
        });
        step("Активируем поле поисковика", () -> {
        $(".TextInput-icon").click();
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
        $("input[placeholder='Search or jump to...']")
                .setValue(REPOSITORY)
                .pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
        $("a[href=\"/azarsen1/HW_With_Allure_Reports\"]").click();
        });
        step("Кликаем по табу issues ", () -> {
        $("#issues-tab").click();
        });
        step("Проверяем наличие текста \"No results\" ", () -> {
        $(".blankslate-heading").shouldHave(text("No results"));
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.openSearchInput();
        steps.clickSearchInput();
        steps.searchRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeTextWhenIsNotIssues("No results");
    }
}
