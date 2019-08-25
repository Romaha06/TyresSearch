package Service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class Core {
    private static Core instance;
    public WebDriver driver;

    private Core() {
        String pathToDriver = Paths.get("").toAbsolutePath().toString() + "/Drivers/chromedriver.exe";
        System.err.println("PATH: " + pathToDriver);
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    public static Core getInstance() {
        if (instance == null) {
            instance = new Core();
        }
        return instance;
    }
}
