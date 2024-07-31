package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage( WebDriver webDriver){
        driver = webDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutbtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement navigatetoinformationpage;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continuebtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement navigatetooverview;

    @FindBy(id = "finish")
    private WebElement finishbtn;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")
    private WebElement errormessage;

    public void clickFinish(){
        finishbtn.click();
    }

    public void goToOverview(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(navigatetooverview));
    }

    public void clickContinue(){
        continuebtn.click();
    }

    public void enterDetailsSelf(String firstName, String lastName, String postalCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
    }

    public void getResultPayment(String expectedMessage, String expectedPageUrl){
        if (!expectedMessage.isEmpty()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) errormessage)); // Adjust selector as needed
            String actualMessage = messageElement.getText();
            assertEquals(expectedMessage, actualMessage);
        } else if (!expectedPageUrl.isEmpty()) {
            String actualUrl = driver.getCurrentUrl();
            assertEquals(expectedPageUrl, actualUrl);
        }
    }


    public void gotoinformationpage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(navigatetoinformationpage));
    }
    
    public void clickCheckout(){
        checkoutbtn.click();
    }




}
