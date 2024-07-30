package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilterHomePage {

    WebDriver driver;

    public FilterHomePage(WebDriver webDrivers) {
        driver = webDrivers;
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(className = "product_sort_container")
    private WebElement filterbtn;

    @FindBy(css = "select option[value='az']")
    private WebElement filterAtoZ;

    @FindBy(css = "select option[value='lohi']")
    private WebElement filterlohi;

    @FindBy(css = "select option[value='hilo']")
    private WebElement filterhilo;

    @FindBy(css = "select option[value='za']")
    private WebElement filterZtoA;

    private By productListLocator = By.className("inventory_item_name");

    private By productListInventory = By.cssSelector(".inventory_item");

    private By productPrice = By.cssSelector(".inventory_item_price[data-test='inventory-item-price']");


    //Methods

    public void clickFilter(){
        filterbtn.click();
    }

    public void clickztoa(){
        filterZtoA.click();
    }

    public void clickatoz(){
        filterAtoZ.click();
    }

    public void clicklowtohigh() throws InterruptedException {
        filterlohi.click();
        Thread.sleep(2000);
    }

    public void clickhightolow(){
        filterhilo.click();
    }

    public void ListProductZkeA(){
        List<WebElement> items = driver.findElements(productListLocator);

        List<String> itemTexts = new ArrayList<>();
        for (WebElement item : items) {
            itemTexts.add(item.getText());
        }

        List<String> sortedItemTexts = new ArrayList<>(itemTexts);
        Collections.sort(sortedItemTexts, Collections.reverseOrder());

        // Assert that the original list is sorted in reverse order
        if (!itemTexts.equals(sortedItemTexts)) {
            throw new AssertionError("Daftar tidak terurut dari Z ke A.");
        }
    }

    public void ListProductAtoZ(){
        List<WebElement> items = driver.findElements(productListLocator);

        List<String> itemTexts = new ArrayList<>();
        for (WebElement item : items) {
            itemTexts.add(item.getText());
        }

        List<String> sortedItemTexts = new ArrayList<>(itemTexts);
        Collections.sort(sortedItemTexts); // Mengurutkan dari A ke Z

        // Assert that the original list is sorted in ascending order
        if (!itemTexts.equals(sortedItemTexts)) {
            throw new AssertionError("Daftar tidak terurut dari A ke Z.");
        }
    }

    public void ListProductLowtoHigh(){
        List<WebElement> items = driver.findElements(productListInventory);

        List<Double> itemPrices = new ArrayList<>();
        for (WebElement item : items) {
            WebElement priceElement = item.findElement(productPrice);

            String priceText = priceElement.getText().replace("$", "").replace(",", ""); // Bersihkan format harga
            double price = Double.parseDouble(priceText);
            itemPrices.add(price);
        }

        List<Double> sortedItemPrices = new ArrayList<>(itemPrices);
        Collections.sort(sortedItemPrices);


        System.out.println("Harga produk dari yang terendah ke yang tertinggi:");
        for (Double price : sortedItemPrices) {
            System.out.println("$" + price);
        }
    }

    public void ListProductHightoLow(){
        List<WebElement> items = driver.findElements(productListInventory);

        List<Double> itemPrices = new ArrayList<>();
        for (WebElement item : items) {
            WebElement priceElement = item.findElement(productPrice);

            String priceText = priceElement.getText().replace("$", "").replace(",", ""); // Bersihkan format harga
            double price = Double.parseDouble(priceText);
            itemPrices.add(price);
        }


        List<Double> sortedItemPrices = new ArrayList<>(itemPrices);
        Collections.sort(sortedItemPrices, Collections.reverseOrder());


        System.out.println("Harga produk dari yang tertinggi ke yang terendah:");
        for (Double price : sortedItemPrices) {
            System.out.println("$" + price);
        }
    }

}
