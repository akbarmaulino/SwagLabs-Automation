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

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement navigatetoresultpage;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")
    private WebElement errorMessageElement;

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

//    public void enterDetailsSelf(String firstName, String lastName, String postalCode) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(firstNameField));
//
//        if (firstName.equals("[empty]")) {
//            firstNameField.sendKeys("");
//        } else {
//            firstNameField.sendKeys(firstName);
//        }
//
//        if (lastName.equals("[empty]")) {
//            lastNameField.sendKeys("");
//        } else {
//            lastNameField.sendKeys(lastName);
//        }
//
//        if (postalCode.equals("[empty]")) {
//            postalCodeField.sendKeys("");
//        } else {
//            postalCodeField.sendKeys(postalCode);
//        }
//
//        System.out.println("First Name: " + firstName);
//        System.out.println("Last Name: " + lastName);
//        System.out.println("Postal Code: " + postalCode);
//
//    }

    public void enterFirstName(String firstName){
        if (firstName.equals("[empty]")) {
            firstNameField.sendKeys("");
        } else {
            firstNameField.sendKeys(firstName);
        }

        System.out.println("First Name: " + firstName);

    }

    public void enterLastName(String lastName) {
        if (lastName.equals("[empty]")) {
            lastNameField.sendKeys("");
        } else {
            lastNameField.sendKeys(lastName);
        }
        System.out.println("Last Name: " + lastName);

    }

    public void enterPostalCode(String postalCode) {
        if (postalCode.equals("[empty]")) {
            postalCodeField.sendKeys("");
        } else {
            postalCodeField.sendKeys(postalCode);
        }
        System.out.println("Postal Code: " + postalCode);
    }



    public void goToResultPayment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(navigatetoresultpage));
    }

    public void gotoinformationpage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(navigatetoinformationpage));
    }
    
    public void clickCheckout(){
        checkoutbtn.click();
    }

    public String getErrorMessage() {
        System.out.println(errorMessageElement.getText());
        return errorMessageElement.getText();

    }




}
