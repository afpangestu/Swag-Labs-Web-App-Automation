package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By continueShoppingBtn = By.xpath("//button[@id='continue-shopping']");

    // actions
    public void clickContinueShoppingBtn() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueShoppingBtn)
        );
        driver.findElement(continueShoppingBtn).click();
    }
}
