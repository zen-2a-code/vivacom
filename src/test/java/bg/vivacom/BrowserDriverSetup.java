package bg.vivacom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BrowserDriverSetup {
    private static WebDriver driver;

    private static void initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // This method uses singleton pattern
    @BeforeSuite(groups = {"EndToEndTest"})
    public static WebDriver getDriver() {
        if (driver == null) {
//            closeOpenSeasons();
            initializeDriver();
        }
        return driver;
    }

    @AfterSuite(groups = {"EndToEndTest"})
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static void closeOpenSeasons() {
        // Close all Google Chrome windows before opening the page.
        // As per task: Да се изчистват отворени browser-и/сесии преди отварянето на нов browser.
        // This is tested only on Windows as targeted platform. The task never mentions the OS

        String osName = System.getProperty("os.name").toLowerCase();
        try {
            if (osName.contains("win")) {
                // Windows OS
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            } else {
                // Linux and MacOS
                Runtime.getRuntime().exec("pkill -f 'Google Chrome'");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
