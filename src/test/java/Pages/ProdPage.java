package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class ProdPage {
    WebDriver driver;
    //Boolean IsLoggedIn;

    private static final By ADD = By.cssSelector(".btn.btn-success.btn-lg");
    private static final By CART = By.id("cartur");
    private static final By HOME = By.id("nava");


    public ProdPage(WebDriver driver) {
        this.driver = driver;
        //this.IsLoggedIn = this.driver.findElement(WELCOME).getCssValue("display").equals("block");
    }

    public HomePage GoHome(){
        this.driver.findElement(HOME).click();
        return new HomePage(this.driver);
    }

    public ProdPage AddToCart() throws InterruptedException {
        String currHandle=driver.getWindowHandle();
        this.driver.findElement(ADD).click();
        int i=0;
        while(i<100)//ждем пока появится предупреждение вверху страницы
        {
            i++;
            try
            {
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
                this.driver.switchTo().window(currHandle);
                break;
            }
            catch(NoAlertPresentException e)
            {
                sleep(100);
            }
        }
        return this;
    }

    public CartPage GoToCart(){
        this.driver.findElement(CART).click();
        return new CartPage(this.driver);
    }
}
