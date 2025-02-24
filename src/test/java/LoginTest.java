import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LoginTest {

    @Test
    public void checkNegativeLoginWrongPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        driver.manage().window().maximize();
        //настройка ожидания при поиске элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_formula");
        driver.findElement(By.id("login-button")).click();
        sleep(1000);

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        //Epic sadface: Username and password do not match any user in this service
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }



    @Test
    public void checkNegativeLoginCloseErrorMessage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
        driver.manage().window().maximize();
        //настройка ожидания при поиске элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_formula");
        driver.findElement(By.id("login-button")).click();
        sleep(1000);
        driver.findElement(By.id("login-button")).click();
        sleep(1000);
        driver.findElement(By.cssSelector("[data-test=error-button]")).click();
        String flexVal = driver.findElement(By.cssSelector("[class=error-message-container]")).getCssValue("flex");

        Assert.assertEquals(flexVal.substring(flexVal.length() - 2), "0%");
        driver.quit();
    }
}
