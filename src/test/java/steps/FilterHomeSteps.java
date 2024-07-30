package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FilterHomePage;

public class FilterHomeSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private FilterHomePage filterhomepage;


    @When("User click filter")
    public void userclickfilter(){
        driver = Hooks.getDriver();
        filterhomepage = new FilterHomePage(driver);
        filterhomepage.clickFilter();
    }

    @And("User Choose Filter Name\\(Z to A)")
    public void userChooseFilterNameZToA() {
        filterhomepage.clickztoa();
    }

    @And("User Choose Filter Name\\(A to Z)")
    public void userChooseFilterNameAToZ() {
        filterhomepage.ListProductAtoZ();
    }

    @And("User Choose Filter Price\\(Low to High)")
    public void userChooseFilterPriceLowToHigh() throws InterruptedException {
        filterhomepage.clicklowtohigh();
    }

    @Then("The Product Should sort By Name Z to A")
    public void theProductShouldSortByNameZToA() {
        filterhomepage.ListProductZkeA();
    }

    @Then("The Product Should sort By Name A to Z")
    public void theProductShouldSortByNameAToZ() {
        filterhomepage.clickztoa();
        filterhomepage.clickFilter();
        filterhomepage.clickatoz();
    }

    @Then("The Product Should sort By Price\\(Low to High)")
    public void theProductShouldSortByPriceLowToHigh() {
        filterhomepage.ListProductLowtoHigh();
    }

    @And("User Choose Filter Price\\(High to Low)")
    public void userChooseFilterPriceHighToLow() {
        filterhomepage.clickhightolow();
    }

    @Then("The Product Should sort By Price\\(High to Low)")
    public void theProductShouldSortByPriceHighToLow() {
        filterhomepage.ListProductHightoLow();
    }
}
