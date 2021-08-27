import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends MainPage {
    SelenideElement loginField = $(By.id("user-name"));
    SelenideElement passwordField = $(By.id("password"));
    SelenideElement signInButton = $(By.name("login-button"));
    //SelenideElement logoutButton = $(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]"));
    void login() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        loginField.sendKeys(props.getProperty("user.username"));
        passwordField.sendKeys(props.getProperty("user.password"));
        signInButton.click();
    }
    public void openLoginPage(){
        open("https://www.saucedemo.com/");
    }
}



