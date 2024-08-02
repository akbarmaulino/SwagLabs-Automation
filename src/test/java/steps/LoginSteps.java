package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;


import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User In On Login Page")
    public void userinonloginpage(){
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.usernamefielddisplayed();
        loginPage.passwordfielddisplayed();
        loginPage.loginbuttondisplayed();
    }

    @When("User Enter Valid Credential")
    public void userentervalidcredential() throws InterruptedException {
        loginPage.enterUsernamevalid();
        loginPage.enterPasswordValid();
        Thread.sleep(2000);
    }


    @Then("User Click Login")
    public void userclicklogin() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("User Navigate To Homepage Menu")
    public void usernavigatetohomepagemenu(){
        loginPage.chartbtnisdisplayed();
    }


    @When("^User Enters (.+) and (.+)$")
    public void userentersusernameandpassword1(String username, String Password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(Password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("^User Should Get (.+) In Login Page$")
    public void userShouldGetOutcomeInLoginPage(String expectedOutcome){
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue("Error message is not as expected. Actual: " + actualErrorMessage,
                actualErrorMessage.contains(expectedOutcome));
    }
}
