package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AddToCardPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartStep {

    private WebDriver driver;
    private AddToCardPage addToCardPage;

    @When("User add a product to my cart")
    public void iAddAProductToMyCart(){
        driver = Hooks.getDriver();
        addToCardPage = new AddToCardPage(driver);
        addToCardPage.ClickAddProductBtn();
    }

    @Then("The Product Should Appear In My Cart")
    public void theProductShouldAppearInMyCart(){
        addToCardPage.clickCartIcon();
        addToCardPage.ItemDisplayed();
    }

    @Then("User Add a second product to my cart")
    public void useraddasecondproduct(){
        addToCardPage.ClickAddSecondProductBtn();
    }

    @Then("My Chart Give Item Count")
    public void theproductcountshoulappearinchart(){
        addToCardPage.ItemDisplayed();
    }

    @Then("User Remove Product")
    public void userremoveproduct() throws InterruptedException {
        addToCardPage.ClickAddProductBtn();
        Thread.sleep(2000);

    }


}
