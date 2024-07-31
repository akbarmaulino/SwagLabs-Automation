package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutSteps {
    private WebDriver driver;
    private LogoutPage logoutPage;
    private LoginPage loginPage;

    @When("User Click Button Burger Menu")
    public void user_click_button_burger_menu() {
        driver = Hooks.getDriver();
        logoutPage = new LogoutPage(driver);
        logoutPage.clickBurgerbtn();
    }

    @And("User Click Logout")
    public void user_click_logout() {
        logoutPage.clickLogout();
    }

    @Then("User Navigate To Login Page")
    public void user_navigate_to_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.usernamefielddisplayed();
        loginPage.passwordfielddisplayed();
        loginPage.loginbuttondisplayed();
    }
}
