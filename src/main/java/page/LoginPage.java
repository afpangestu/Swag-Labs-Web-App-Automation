package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    Duration duration = Duration.ofSeconds(10);

    // contructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMsgIncorrect)
        );
    }

    public void setErrorMsgBlank() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMsgBlank)
        );
    }
}
