package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By logoSwag = By.xpath("//div[@class='app_logo']");
    By cartBtn = By.xpath("//a[@class='shopping_cart_link']");
    By sortBtn = By.xpath("//select[@class='product_sort_container']");

    // all product locator
//    By allImgProductAlternative = By.xpath("//a[not(@href)]/img/@src | //a[img]/@href");
    By allImgProduct = By.xpath("//img[@class='inventory_item_img']");
    By allTitleProduct = By.xpath("//div[@class='inventory_item_name ']");
    By allDescProduct = By.xpath("//div[@class='inventory_item_desc']");
    By allPriceProduct = By.xpath("//div[@class='inventory_item_price']");
    By allAddToCartBtnProduct = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");

    // single product locator
    By titleProduct1 = By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']");
    By imgProduct1 = By.xpath("//*[@id='item_4_img_link']/img");
    By descProduct1 = By.xpath("//div[normalize-space()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']");
    By priceProduct1 = By.xpath("//div[normalize-space()='$29.99']");
    By addToCartProduct1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    // actions
    public boolean checkLogoSwag() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(logoSwag)
        );
        return driver.findElement(logoSwag).isDisplayed();
    }

    public void clickCartBtn() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cartBtn)
        );
        driver.findElement(cartBtn).click();
    }
}