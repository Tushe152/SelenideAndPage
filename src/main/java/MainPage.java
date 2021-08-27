import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;


public class MainPage  {
    SelenideElement homeButton = $("a[data-test='home']");
    SelenideElement addressesButton = $("a[data-test='addresses']");
    SelenideElement sighOutButton = $("a[data-test='sign-out']");
    SelenideElement currentUser = $("span[data-test='current-user']");
    SelenideElement products = $(By.id("header_container"));
    SelenideElement listOfElements = $(By.id("inventory_container"));
    SelenideElement cartBtn = $(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
    SelenideElement addToCArtBackpack = $(By.name("add-to-cart-sauce-labs-backpack"));
    SelenideElement addToCArtLight = $(By.name("add-to-cart-sauce-labs-bike-light"));
    SelenideElement addToCArtTShirt = $(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
    SelenideElement shoppingCartBadge = $(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));

    void buy() throws IOException {
        Log.info("Buying backpack, lights and T-shirt");
        addToCArtBackpack.click();
        addToCArtLight.click();
        addToCArtTShirt.click();

    }
}



