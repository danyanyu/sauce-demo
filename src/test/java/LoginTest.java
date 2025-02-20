import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {

    @Test
    public void checkLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        driver.quit();
    }
}
