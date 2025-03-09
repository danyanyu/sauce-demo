package Pages;

import Dto.UserProfile;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class HomePage {
    WebDriver driver;
    //Boolean IsLoggedIn;
    public String SignUpError;
    public String LoginError;
    public String DisplayModal;


    private static final By LOG_IN = By.id("login2");
    private static final By SIGN_UP = By.id("signin2");
    private static final By WELCOME = By.id("nameofuser");
    private static final By REGISTERBTN = By.cssSelector("[onclick=\"register()\"]");
    private static final By LOGINBTN = By.cssSelector("[onclick=\"logIn()\"]");
    private static final By LOGIN_INPUT_SIGNIN = By.id("sign-username");
    private static final By PASSWORD_INPUT_SIGNIN = By.id("sign-password");
    private static final By LOGIN_INPUT_LOGIN = By.id("loginusername");
    private static final By PASSWORD_INPUT_LOGIN = By.id("loginpassword");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.SignUpError = "";
        //this.IsLoggedIn = this.driver.findElement(WELCOME).getCssValue("display").equals("block");
    }

    public HomePage open() {
        driver.get("https://demoblaze.com/");
        return this;
    }

    public HomePage sign_up(String login, String pwd) throws InterruptedException {
        String currHandle=driver.getWindowHandle();
        this.driver.findElement(SIGN_UP).click();
        this.driver.findElement(LOGIN_INPUT_SIGNIN).sendKeys(login);
        this.driver.findElement(PASSWORD_INPUT_SIGNIN).sendKeys(pwd);
        this.driver.findElement(REGISTERBTN).click();
        while(true)//ждем пока появится предупреждение вверху страницы
        {
            try
            {
                Alert alert = driver.switchTo().alert();
                this.SignUpError = alert.getText();
                break;
            }
            catch(NoAlertPresentException e)
            {
                sleep(100);
                continue;
            }
        }
        this.driver.switchTo().alert().dismiss();
        this.driver.switchTo().window(currHandle);
        Actions closeForm  = new Actions(driver);
        closeForm.sendKeys(Keys.ESCAPE).perform();
        sleep(1000);//костыль, окно должно исчезнуть, но надо подождать, чтобы аттрибуты обновились
        this.DisplayModal = this.driver.findElement(By.id("signInModal")).getCssValue("display");
        return this;
    }

    public HomePage log_in(String login, String pwd) throws InterruptedException{
        this.driver.findElement(LOG_IN).click();
        String currHandle=driver.getWindowHandle();
        this.driver.findElement(LOGIN_INPUT_LOGIN).sendKeys(login);
        this.driver.findElement(PASSWORD_INPUT_LOGIN).sendKeys(pwd);
        this.driver.findElement(LOGINBTN).click();
        int i = 0;
        while(i<20)//ждем пока появится предупреждение вверху страницы
        {
            i++;
            try {
                Alert alert = driver.switchTo().alert();
                this.LoginError = alert.getText();
                this.driver.switchTo().alert().dismiss();
                this.driver.switchTo().window(currHandle);
                Actions closeForm  = new Actions(driver);
                closeForm.sendKeys(Keys.ESCAPE).perform();
                return this;
            } catch (NoAlertPresentException e) {
                sleep(100);
                continue;
            }
        }

        return this;
    }
}
