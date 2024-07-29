package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPages;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver = null;


    @Before
    public void browsersetup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi Donwload\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @Given("User In On Login Page")
    public void user_go_to_profiln_website() {
        driver.get("https://www.saucedemo.com/");
    }

//    @When("^User Enter Valid (.*) and (.*)$")
//    public void userentervalidemailandpassword(String username, String password) throws InterruptedException {
//        System.out.println("User Alredy in Steps Enter Valid Email and Password");
//        LoginPages login = new LoginPages(driver);
//        login.enterusername(username);
//        login.enterpassword(password);
//        Thread.sleep(2000);
//    }

    @When("User Enter Valid Credential")
    public void userentervalidemailandpassword() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";
        LoginPages login = new LoginPages(driver);
        login.enterusername(username);
        login.enterpassword(password);
        Thread.sleep(2000);
    }

    @Then("User Click Login")
    public void userclicklogin(){
        System.out.println("User already in steps to click login");
        LoginPages login = new LoginPages(driver);
        login.clickLogin();
    }

    @Then("User Navigate To Homepage Menu")
    public void usernavigatetohomepagemenu(){
        System.out.println("User already in steps to navigate to homepage menu");
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).isDisplayed();
        System.out.println(("User Finish Steps using POM"));
    }
}





