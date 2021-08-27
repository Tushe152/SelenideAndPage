import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement deleteLight = $(By.id("remove-sauce-labs-bike-light"));
    SelenideElement deleteBackpack = $(By.id("remove-sauce-labs-backpack"));
    SelenideElement deleteTshirt = $(By.id("remove-sauce-labs-bolt-t-shirt"));
    SelenideElement checkout = $(By.id("checkout"));
    SelenideElement firstName = $(By.id("first-name"));
    SelenideElement lastName = $(By.id("last-name"));
    SelenideElement zipCode = $(By.id("postal-code"));
    SelenideElement checkOutContinue = $(By.id("continue"));
    SelenideElement itemTotal = $(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]/text()[2]"));
    SelenideElement firstItemPrice = $(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div/text()[2]"));
    SelenideElement secondItemPrice = $(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div/text()[2]"));
    SelenideElement thirdItemPrice = $(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[5]/div[2]/div[2]/div/text()[2]"));




    void deleteSomeItems() throws IOException{
        Log.info("Deleting some items");
        deleteBackpack.click();
        deleteLight.click();
        deleteTshirt.click();
    }
    void checkoutFill() throws IOException{
        firstName.sendKeys("Max");
        lastName.sendKeys("Zax");
        zipCode.sendKeys("321123");
        checkOutContinue.click();


    }



}
