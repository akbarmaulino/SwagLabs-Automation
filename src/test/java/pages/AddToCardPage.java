package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCardPage {
    WebDriver driver;

    public AddToCardPage(WebDriver webDrivers) {
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addProductBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement addToCartIcon;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
    private WebElement ItemDisplayedinChart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartItemCount;

    //Methods


    public void clickCartIcon(){
        addToCartIcon.click();
    }

    public void ClickAddProductBtn(){
        addProductBtn.click();
    }

    public WebElement getCartItemCount() {
        return cartItemCount;
    }

    public void ItemDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ItemDisplayedinChart));
    }


}

