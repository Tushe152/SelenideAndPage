import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwagLabsTest {
    @BeforeEach
    public void setUp() {
//        Configuration.headless = true;
        Configuration.startMaximized = true;
    }
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
    @Test
    @Order(1)
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.products.shouldBe(visible);
       // Assertions.assertEquals("Products", loginPage.products.getText());
    }
    @Test
    @Order(2)
    public void buySomeTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.openLoginPage();
        loginPage.login();
        mainPage.buy();
        mainPage.shoppingCartBadge.shouldBe(visible);
        Assertions.assertEquals("3",mainPage.shoppingCartBadge.getText());
    }
    @Test
    @Order(3)
    public void deleteItems() throws IOException {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        CartPage cartPage = new CartPage();
        loginPage.openLoginPage();
        loginPage.login();
        mainPage.buy();
        mainPage.shoppingCartBadge.shouldBe(visible);
        Log.info("check if items are in cart");
        Assertions.assertEquals("3",mainPage.shoppingCartBadge.getText());
        mainPage.cartBtn.click();
        cartPage.deleteSomeItems();
        Assertions.assertEquals(cartPage.deleteLight.shouldNot(visible),cartPage.deleteLight);

    }
    @Test
    @Order(4)
    public void buSomeWithPriceCheckingTest() throws IOException{
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        CartPage cartPage = new CartPage();
        loginPage.openLoginPage();
        loginPage.login();
        mainPage.buy();
        mainPage.shoppingCartBadge.shouldBe(visible);
        Assertions.assertEquals("3",mainPage.shoppingCartBadge.getText());
        mainPage.cartBtn.click();
        cartPage.checkout.click();
        cartPage.checkoutFill();
        double subTotal = Double.parseDouble(cartPage.firstItemPrice.getValue()+ cartPage.secondItemPrice.getValue() + cartPage.thirdItemPrice.getValue());
        double itemTotal = Double.parseDouble(cartPage.itemTotal.getValue());
        Assertions.assertEquals(itemTotal,subTotal,"sum is incorrect");




    }
}
