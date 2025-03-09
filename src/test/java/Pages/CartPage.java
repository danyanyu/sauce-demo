package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    //Boolean IsLoggedIn;

    private static final By LOG_IN = By.id("login2");
    private static final By SIGN_UP = By.id("signin2");
    private static final By WELCOME = By.id("nameofuser");
    private static final By REGISTER = By.cssSelector("[onclick=register()]");
    private static final By LOGIN_INPUT_SIGNIN = By.id("sign-username");
    private static final By PASSWORD_INPUT_SIGNIN = By.id("sign-password");
    private static final By CLOSE_SINGIN_MODAL = By.cssSelector("[class=btn btn-secondary]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        //this.IsLoggedIn = this.driver.findElement(WELCOME).getCssValue("display").equals("block");
    }
}
