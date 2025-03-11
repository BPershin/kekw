import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Paths;

public class WebDriverConfig {
    private static final String DRIVER_NAME_WINDOWS = "chromedriver.exe";
    private static final String DRIVER_NAME_LINUX = "chromedriver";

    private static final String RESOURCE_FOLDER = "src/main/resources/drivers/";

    public static WebDriver getChromeDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        String driverPath = Paths.get(RESOURCE_FOLDER, getDriverFileName(osName)).toString();

        File file = new File(driverPath);
        if (!file.exists()) {
            throw new RuntimeException("Cannot find driver at path: " + driverPath);
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        Configuration.timeout = 5000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    private static String getDriverFileName(String osName) {
        if (osName.contains("win")) {
            return DRIVER_NAME_WINDOWS;
        } else {
            return DRIVER_NAME_LINUX;
        }
    }
}

