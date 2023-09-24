package browserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CrossBrowserTesting {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        File file = new File("config.properties");

        FileInputStream fis = new FileInputStream(file);
        prop.load( fis );

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = null;

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Provide a valid Browser Name");
        }
        driver.get("https://www.amazon.in/");
    }
}
