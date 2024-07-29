package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {

    WebDriver driver;

    By txt_Username = By.id("user-name");
    By txt_Password = By.id("password");
    By btn_Login = By.id("login-button");

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

//    ------For Many Account-------
//    public void enterusername(String username) {
//        driver.findElement(txt_Username).sendKeys(username);
//    }
//
//    public void enterpassword(String password) {
//        driver.findElement(txt_Password).sendKeys(password);
//    }
//    ------For Many Account-------

//    ------For One Account-------
    public void enterusername(String username) {
        String Username = "standard_user";
        driver.findElement(txt_Username).sendKeys(username);
    }

    public void enterpassword(String password) {
        String Password = "secret_sauce";
        driver.findElement(txt_Password).sendKeys(password);
    }
//    ------For One Account-------


    public void clickLogin() {
        driver.findElement(btn_Login).click();
    }
}
