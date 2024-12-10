package page;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterMenu {
    WebDriver driver;
    Duration duration = Duration.ofSeconds(10);
    BaseUtil baseUtil;

    // contructor
    public FooterMenu(WebDriver driver) {
        this.driver = driver;
    }

    // locator
    By twitterBtn = By.xpath("//a[normalize-space()='Twitter']");
    By facebookBtn = By.xpath("//a[normalize-space()='Facebook']");
    By linkedInBtn = By.xpath("//a[normalize-space()='LinkedIn']");

    // actions
    public void clickTwitterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(twitterBtn)
        );
        driver.findElement(twitterBtn).click();
    }

    public void clickFacebookBtn() {
        driver.findElement(facebookBtn).click();
    }

    public void clickLinkedInBtn() {
        driver.findElement(linkedInBtn).click();
    }
}
