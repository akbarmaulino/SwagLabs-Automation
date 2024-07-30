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
        loginPage.enterUsername();
        loginPage.enterPassword();
        Thread.sleep(2000);
    }

    @When("User Enter Lock Account")
    public void userenterlockaccount() throws InterruptedException{
        loginPage.enterUsernameLock();
        loginPage.enterPassword();
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

    @Then("User Get Error Message")
    public void usergeterrormessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.errormessagedisplayed()));

        // Verify the error message
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = loginPage.errormessagedisplayed().getText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        System.out.println(actualErrorMessage);
    }


}
