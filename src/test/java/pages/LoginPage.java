package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    String Username = "performance_glitch_user";
    String UsernameLock = "locked_out_user";
    String Password = "secret_sauce";

    public LoginPage(WebDriver webDrivers){
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement chartBtn;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement errormessage;


    public void enterUsername(){
        userName.sendKeys(Username);

    }

    public void enterUsernameLock(){
        userName.sendKeys(UsernameLock);
    }

    public void enterPassword(){
        password.sendKeys(Password);
    }

    public void clickLoginButton(){
        logInBtn.click();
    }

    public void usernamefielddisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userName));
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

    public WebElement errormessagedisplayed(){
        return errormessage;

    }

}
