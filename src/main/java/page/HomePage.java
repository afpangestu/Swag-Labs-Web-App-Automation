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
    By allImgProduct = By.xpath("//img[@class='inventory_item_img']");
    By allTitleProduct = By.xpath("//div[@class='inventory_item_name ']");
    By allDescProduct = By.xpath("//div[@class='inventory_item_desc']");
    By allPriceProduct = By.xpath("//div[@class='inventory_item_price']");
    By allAddToCartBtnProduct = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    // alternative
//    By allImgProductAlternative = By.xpath("//a[not(@href)]/img/@src | //a[img]/@href");

    // single product locator
    By titleProduct1 = By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']");
    By imgProduct1 = By.xpath("//*[@id='item_4_img_link']/img");
    By descProduct1 = By.xpath("//div[normalize-space()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']");
    By priceProduct1 = By.xpath("//div[normalize-space()='$29.99']");
    By addToCartProduct1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    // sort item locator
    By sortAZ = By.xpath("//*[@value='az']");
    By sortZA = By.xpath("//*[@value='za']");
    By sortLoHi = By.xpath("//*[@value='lohi']");
    By sortHiLo = By.xpath("//*[@value='hilo']");

    // actions
    public boolean checkLogoSwag() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoSwag)).isDisplayed();
    }

    public String getTextLogo() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(logoSwag)).getText();
    }

    public void clickCartBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }

    public boolean getAllProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allImgProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allTitleProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allDescProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allPriceProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allAddToCartBtnProduct));
        return true;
    }

    public void clickProduct() {
        driver.findElement(titleProduct1).click();
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleProduct1)).getText();
    }

    public String getProductImg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imgProduct1)).getDomProperty("src");
    }

    public String getProductDesc() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descProduct1)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceProduct1)).getText();
    }

    public void clickSortAZ() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortAZ)).click();
    }

    public void clickSortZA() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortZA)).click();
    }

    public void clickSortLoHi() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortLoHi)).click();
    }

    public void clickSortHiLo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortHiLo)).click();
    }

    public void clickAddToCart1() {
        driver.findElement(addToCartProduct1).click();
    }
}
