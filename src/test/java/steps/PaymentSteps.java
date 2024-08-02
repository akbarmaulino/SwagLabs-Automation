package steps;

import com.google.j2objc.annotations.Weak;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PaymentPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PaymentSteps {

    private WebDriver driver;
    private PaymentPage paymentpage;

    @Given("User Click Checkout")
    public void userClickCheckout() {
        driver = Hooks.getDriver();
        paymentpage = new PaymentPage(driver);
        paymentpage.clickCheckout();
    }

    @And("User Navigate To Payment Page")
    public void userNavigateToPaymentPage() {
        paymentpage.gotoinformationpage();
    }

    @When("^User Enter (.+) (.+) and (.+)$")
    public void userEnterDetails(String firstName, String lastName, String postalCode) throws InterruptedException {
//        paymentpage.enterDetailsSelf(firstName, lastName, postalCode);
        paymentpage.enterFirstName(firstName);
        paymentpage.enterLastName(lastName);
        paymentpage.enterPostalCode(postalCode);
        Thread.sleep(2000);
    }

    @And("User Click Continue")
    public void userClickContinue() {
        paymentpage.clickContinue();
    }

    @And("User Navigate To Checkout Overview")
    public void userNavigateToCheckoutOverview() {
        paymentpage.goToOverview();
    }

    @Then("User Click Finish")
    public void userClickFinish() {
        paymentpage.clickFinish();
    }

    @And("User Should Navigate To Complete Checkout Menu")
    public void userShouldNavigateToCompleteCheckoutMenu() {
        paymentpage.goToResultPayment();
    }

    @Then("^User Should Get (.+) In Payment Page$")
    public void userShouldGetOutcomeInPaymentPage(String expectedOutcome){
        String actualErrorMessage = paymentpage.getErrorMessage();
        assertTrue("Error message is not as expected. Actual: " + actualErrorMessage,
                actualErrorMessage.contains(expectedOutcome));
    }
}
