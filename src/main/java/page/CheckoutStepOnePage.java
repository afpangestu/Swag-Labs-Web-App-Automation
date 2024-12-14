package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By errorMsg = By.xpath("//*[contains(text(),'Error')]");
    By continueToStepTwoBtn = By.xpath("//*[@id='continue']");
    By cancelBtn = By.xpath("//*[@id='cancel']");
    By firstNameTxt = By.xpath("//*[@id='first-name']");
    By lastNameTxt = By.xpath("//*[@id='last-name']");
    By zipCodeTxt = By.xpath("//*[@id='postal-code']");

    // actions
    public void getErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
    }

    public void clickContinueBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(continueToStepTwoBtn)).click();
    }

    public void clickCancelBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
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
