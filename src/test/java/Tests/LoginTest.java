package Tests;

import Dto.UserProfile;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    @Test
    public void NegativeSignUpTest() throws InterruptedException{
        this.homePage
                .open()
                .sign_up(usr.login,usr.password);
        assertEquals(homePage.SignUpError,"This user already exist.");
    }

    @Test
    public void NegativeLoginTest() throws InterruptedException{
        this.homePage
                .open()
                .log_in(usr.login,usr.password+"8");
        assertEquals(homePage.LoginError,"Wrong password.");
    }

    @Test
    public void ModalClosingTest() throws InterruptedException{
        this.homePage
                .open()
                .sign_up(usr.login,usr.password);
        assertEquals(homePage.DisplayModal,"none");
    }

    @Test
    public void PositiveLoginTest() throws InterruptedException{
        this.homePage
                .open()
                .log_in(usr.login,usr.password);
        assertEquals(this.driver.findElement(By.id("nameofuser")).getText(),"Welcome "+usr.login);
    }

}
