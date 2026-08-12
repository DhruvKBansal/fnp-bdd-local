package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public static WebDriver webDriver;
    public static FileInputStream configFileInputStream;
    public static Properties configProperties;

    public static String excelFilePath;
    public static String reportsDirectoryPath;
    public static String screenshotsDirectoryPath;

    public void loadProperties() throws IOException {
        String propertiesPath = System.getProperty("user.dir") + "/config/config.properties";
        try {
            configFileInputStream = new FileInputStream(propertiesPath);
            configProperties = new Properties();
            configProperties.load(configFileInputStream);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static void loadConfig() {
        String configPath = System.getProperty("user.dir") + "/config/config.properties";
        try (FileInputStream fileInputStream = new FileInputStream(configPath)) {

            if (configProperties == null)
                configProperties = new Properties();

            configProperties.load(fileInputStream);

            excelFilePath = System.getProperty("user.dir") + "/" + configProperties.getProperty("excelPath");
            reportsDirectoryPath = System.getProperty("user.dir") + "/" + configProperties.getProperty("reportsPath");
            screenshotsDirectoryPath = System.getProperty("user.dir") + "/" + configProperties.getProperty("screenshotsPath");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void openBrowser() {

        loadConfig();
        try {
            loadProperties();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        String browserName = configProperties.getProperty("browser");

        switch (browserName.toLowerCase()) {
            case "chrome":
                webDriver = new ChromeDriver();
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            default:
                System.err.println("Unsupported browser: " + browserName);
                break;
        }

        if (webDriver != null) {
            webDriver.manage().window().maximize();
            webDriver.get(configProperties.getProperty("url"));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

    }

}
 
