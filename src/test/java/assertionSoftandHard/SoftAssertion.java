package assertionSoftandHard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class SoftAssertion {
    public static void main(String[] args) throws InterruptedException {

        SoftAssert soft = new SoftAssert();

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.it.microtechlimited.com/");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        //Assert.assertTrue(driver.getTitle().equals("MicroTech NA"));
        soft.assertTrue(driver.getTitle().equals("MicroTech NA123"));

        String x = driver.findElement(By.xpath("//h1[text()='Welcome to MicroTech NA.']")).getText();
        soft.assertEquals(x, "Welcome to MicroTech NA.");

        driver.findElement(By.xpath("//a[@href='elogin.php']")).click();
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();

        Thread.sleep(2000);
        driver.quit();

        soft.assertAll();
    }
}