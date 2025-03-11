import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverConfig.getChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Tag("kek")
    public void shouldOpenPageAndCheckTitle() {
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        open("https://google.com");
        WebElement titleElement = $x("//*[@id=\"APjFqb\"]");
        titleElement.sendKeys("hello!");
        assertEquals(1, 1);
    }
}
