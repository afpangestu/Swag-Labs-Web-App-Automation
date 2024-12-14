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
    By firstNameTxt = By.xpath("//input[@id='first-name']");
    By lastNameTxt = By.xpath("//input[@id='last-name']");
    By zipCodeTxt = By.xpath("//input[@id='postal-code']");

    // actions
    public void clickContinueShoppingBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameTxt).clear();
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(zipCodeTxt).clear();
        driver.findElement(zipCodeTxt).sendKeys(zipCode);
    }
}
