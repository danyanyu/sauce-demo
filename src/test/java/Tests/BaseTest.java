package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.*;

import java.time.Duration;

public class BaseTest {
    //String user = System.getProperty("user", PropertyReader.getProperty("user"));
    //String password = System.getProperty("password", PropertyReader.getProperty("password"));

    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    ProdPage prodPage;


    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        prodPage = new ProdPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
