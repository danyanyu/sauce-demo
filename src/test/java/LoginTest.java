import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LoginTest {

    @Test
    public void checkLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");

        sleep(1000);

        driver.quit();
    }
}
