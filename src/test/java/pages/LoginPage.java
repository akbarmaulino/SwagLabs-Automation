package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.desktop.SystemEventListener;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage {
    WebDriver driver;
    String UsernameValid = "performance_glitch_user";
    String PasswordValid = "secret_sauce";

    public LoginPage(WebDriver webDrivers){
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement chartBtn;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement errormessage;


    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessageElement;

    public void enterUsername(String Username){
        if (Username.equals("[empty]")) {
            username.sendKeys("");
        } else {
            username.sendKeys(Username);
        }
    }

    public void enterPassword(String Password) {
        if (Password.equals("[empty]")) {
            password.sendKeys("");
        } else {
            password.sendKeys(Password);
        }
    }


    public void enterUsernamevalid(){
        username.sendKeys(UsernameValid);

    }

    public void enterPasswordValid(){
        password.sendKeys(PasswordValid);
    }

    public void clickLoginButton(){
        logInBtn.click();
    }

    public void usernamefielddisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
    }

    public void passwordfielddisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(password));
    }

    public void loginbuttondisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logInBtn));
    }

    public void chartbtnisdisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(chartBtn));
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }

}
