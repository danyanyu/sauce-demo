package Tests;

import Dto.OrderInfo;
import Dto.UserProfile;
import Pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserSessionTest extends BaseTest{

    UserProfile usr = new UserProfile("JesseyPinkman","Wat3rW8");
    //данные для заполнения заказа
    OrderInfo oInfo = new OrderInfo(
            "Jessey",
            "USA",
            "Albuquerque",
            "2345678923456234",
            "05",
            "2027"
    );

    //Тест нажания на кнопку категории монитор
    @Test
    public void FindMonitorTest() throws InterruptedException {
        this.homePage
                .open()
                .selectCategory(HomePage.Category.monitor);
        assertTrue(homePage.FirstProd.equals("Apple monitor 24")||homePage.FirstProd.equals("ASUS Full HD"));
    }

    //Сквозной тест функционала
    @Test
    public void BasicSessionTest() throws InterruptedException {
        this.cartPage = this.homePage
                .open()
                .sign_up(usr.login, usr.password)
                .log_in(usr.login, usr.password)
                .selectCategory(HomePage.Category.monitor)
                .PickFirstItem()
                .AddToCart()
                .GoToCart()
                .CheckOut(oInfo);
        assertEquals(this.cartPage.SuccessMessage(),"Thank you for your purchase!");

    }

}
