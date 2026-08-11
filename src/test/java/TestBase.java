import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

        @BeforeAll
        static void beforeAll() {
            Configuration.webdriverLogsEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://github.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = false;
        }
        @BeforeEach
        void beforeEach() {
            SelenideLogger.addListener("allure", new AllureSelenide());
        }

        @AfterEach
        void closeWebDriver() {
            Selenide.closeWebDriver();
        }

    }

