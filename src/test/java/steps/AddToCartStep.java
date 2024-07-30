package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddToCardPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AddToCartStep {

    private WebDriver driver;
    private AddToCardPage addToCardPage;

    @When("I add a product to my cart")
    public void iAddAProductToMyCart() throws InterruptedException {
        driver = Hooks.getDriver();
        addToCardPage = new AddToCardPage(driver);
        addToCardPage.ClickAddProductBtn();
        Thread.sleep(2000);
    }

    @Then("The Product Should Appear In My Cart")
    public void theProductShouldAppearInMyCart() throws InterruptedException {
        addToCardPage.clickCartIcon();
        addToCardPage.ItemDisplayed();
        Thread.sleep(2000);
    }

    @Then("My Chart Give Item Count")
    public void theproductcountshoulappearinchart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCardPage.getCartItemCount()));

        // Verify the product count
        String expectedItemCount = "1";
        String actualItemCount = addToCardPage.getCartItemCount().getText();
        assertEquals(expectedItemCount, actualItemCount);
    }


}
