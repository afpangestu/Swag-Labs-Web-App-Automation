package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By completeTxt = By.xpath("//*[contains(text(),'Complete')]");

    // actions
    public void getCompleteText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeTxt)).isDisplayed();
    }
}
