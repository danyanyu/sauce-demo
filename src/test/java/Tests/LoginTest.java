package Tests;

import Dto.UserProfile;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    UserProfile usr = new UserProfile("JesseyPinkman","Wat3rW8");

    //Регистрация под существующей учетной записью
    @Test
    public void NegativeSignUpTest() throws InterruptedException{
        this.homePage
                .open()
                .sign_up(usr.login,usr.password);
        assertEquals(homePage.SignUpError,"This user already exist.");
    }

    //Неверный ввод пароля, ошибка при входе
    @Test
    public void NegativeLoginTest() throws InterruptedException{
        this.homePage
                .open()
                .log_in(usr.login,usr.password+"8");
        assertEquals(homePage.LoginError,"Wrong password.");
    }

    //Проверка того, что модальное окно закрылось после неудачной регистрации
    @Test
    public void ModalClosingTest() throws InterruptedException{
        this.homePage
                .open()
                .sign_up(usr.login,usr.password);
        assertEquals(homePage.DisplayModal,"none");
    }

    //Успешный вход в систему
    @Test
    public void PositiveLoginTest() throws InterruptedException{
        this.homePage
                .open()
                .log_in(usr.login,usr.password);
        assertEquals(this.driver.findElement(By.id("nameofuser")).getText(),"Welcome "+usr.login);
    }

}
