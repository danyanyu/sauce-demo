package Pages;

import Dto.OrderInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    //Boolean IsLoggedIn;

    private static final By PLACE_ORDER = By.cssSelector(".btn.btn-success");
    private static final By PURCHASE_ORDER = By.cssSelector("[onclick=\"purchaseOrder()\"]");
    private static final By NAME = By.id("name");
    private static final By COUNTRY = By.id("country");
    private static final By CITY = By.id("city");
    private static final By CARD = By.id("card");
    private static final By MONTH = By.id("month");
    private static final By YEAR = By.id("year");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage CheckOut(OrderInfo arg){
        this.driver.findElement(PLACE_ORDER).click();
        this.driver.findElement(NAME).sendKeys(arg.Name);
        this.driver.findElement(CITY).sendKeys(arg.City);
        this.driver.findElement(COUNTRY).sendKeys(arg.Country);
        this.driver.findElement(CARD).sendKeys(arg.CreditCard);
        this.driver.findElement(MONTH).sendKeys(arg.Month);
        this.driver.findElement(YEAR).sendKeys(arg.Year);
        this.driver.findElement(PURCHASE_ORDER).click();
        return this;
    }

    public String SuccessMessage(){
        return this.driver
                .findElement(By.cssSelector(".sweet-alert"))
                .findElement(By.tagName("h2")).getText();
    }
}
