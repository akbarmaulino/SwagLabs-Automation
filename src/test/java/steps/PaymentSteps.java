package steps;

import com.google.j2objc.annotations.Weak;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PaymentPage;

import java.time.Duration;

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
    public void userEnterDetails(String firstName, String lastName, String postalCode) {
        paymentpage.enterDetailsSelf(firstName, lastName, postalCode);
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

    @And("^User Should Receive (.+) or Navigate To (.+)$")
    public void userShouldReceiveMessageOrNavigateToPage(String expectedMessage, String expectedPageUrl) {
        paymentpage.getResultPayment(expectedMessage, expectedPageUrl);
    }

    @When("User Enter <First Name> <Last Name> and <Postal Code>")
    public void userEnterFirstNameLastNameAndPostalCode() {
    }
}
