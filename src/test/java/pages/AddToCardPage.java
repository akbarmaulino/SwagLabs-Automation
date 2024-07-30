package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCardPage {
    WebDriver driver;

    public AddToCardPage(WebDriver webDrivers) {
        driver = webDrivers;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(className = "btn_inventory")
    private WebElement addProductBtn;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addSecondProductBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement addToCartIcon;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
    private WebElement ItemDisplayedinChart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartItemCount;

    // Methods

    public void clickCartIcon() {
        addToCartIcon.click();
    }

    public void ClickAddProductBtn() {
        addProductBtn.click();
    }

    public void ClickAddSecondProductBtn() {
        addSecondProductBtn.click();
    }

    public WebElement getCartItemCount() {
        return cartItemCount;
    }

    public void ItemDisplayed() {


        // Verifikasi item count
        String actualItemCount = getCartItemCount().getText();

        String[] expectedItemCounts = {"1"};
        boolean isExpected = false;
        for (String expected : expectedItemCounts) {
            if (expected.equals(actualItemCount)) {
                isExpected = true;
                break;
            }
        }
        assertTrue(isExpected, "Item count is not as expected. Actual: " + actualItemCount);
    }
}
