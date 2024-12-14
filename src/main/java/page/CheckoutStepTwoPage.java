package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage {
    WebDriver driver;
    WebDriverWait wait;
    // contructor

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By finishBtn = By.xpath("//*[@id='finish']");
    By cancelBtn = By.xpath("//*[@id='cancel']");

    // action
    public void clickFinishBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }

    public void clickCancelBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }
}
