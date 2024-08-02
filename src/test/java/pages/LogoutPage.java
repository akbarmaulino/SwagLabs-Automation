package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver webDriver){
        driver = webDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgermenubtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutbtn;

    public void clickBurgerbtn(){
        burgermenubtn.click();
    }

    public void clickLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logoutbtn));

        logoutbtn.click();
    }

}
