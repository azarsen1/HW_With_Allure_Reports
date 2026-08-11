import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest extends TestBase {
    @Test
    public void testIssueSearch() {


        open("/");

        $(".octicon-search").click();
        $(".TextInput-icon").click();
        $("input[placeholder='Search or jump to...']").setValue("azarsen1/HW_With_Allure_Reports").pressEnter();
        $("a[href=\"/azarsen1/HW_With_Allure_Reports\"]").click();
        $("#issues-tab").shouldHave(text("Issues"));
    }


}
