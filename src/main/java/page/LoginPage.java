package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By usernameTxt =  By.xpath("//input[@id='user-name']");
    By passwordTxt = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");
    By errorMsgIncorrect = By.xpath("//*[contains(text(),'Username and password do not match')]");
    By errorMsgBlank = By.xpath("//*[contains(text(),'Epic sadface: Username is required')]");

    // actions
    public void setUsername(String username) {
        driver.findElement(usernameTxt).clear();
        driver.findElement(usernameTxt).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).clear();
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void setErrorMsgIncorrect() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgIncorrect));
    }

    public void setErrorMsgBlank() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgBlank));
    }
}
