package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By titleProductDetails = By.xpath("//div[@class='inventory_details_name large_size']");
    By imageProductDetails = By.className(".inventory_details_img");
    By descProductDetails = By.xpath("//div[@class='inventory_details_desc large_size']");
    By priceProductDetails = By.xpath("//div[@class='inventory_details_price']");
    By addToCartBtnDetails = By.xpath("//button[@id='add-to-cart']");
    By backToProductBtn = By.xpath("//button[@id='back-to-products']");

    // actions
    public String getTitleProductDetails() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleProductDetails)).getText();
    }

    public void getImageProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(imageProductDetails));
    }

    public String getDescProductDetails() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descProductDetails)).getText();
    }

    public String getPriceProductDetails() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceProductDetails)).getText();
    }

    public void clickAddToCartBtnDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtnDetails)).click();
    }

    public void clickBackToProductBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(backToProductBtn)).click();
    }
}
