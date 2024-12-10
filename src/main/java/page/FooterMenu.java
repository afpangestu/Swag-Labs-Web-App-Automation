package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterMenu {
    WebDriver driver;
    Duration duration = Duration.ofSeconds(10);

    // contructor
    public FooterMenu(WebDriver driver) {
        this.driver = driver;
    }

    // locator
    By twitterBtn = By.xpath("//a[normalize-space()='Twitter']");
    By facebookBtn = By.xpath("//a[normalize-space()='Facebook']");
    By linkedInBtn = By.xpath("//a[normalize-space()='LinkedIn']");
    By tosLinkText = By.xpath("//*[contains(text(),'Terms of Service')]");
    By privayLinkText = By.xpath("//*[contains(text(),'Privacy Policy')]");

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

    public void clickTosLinkText() {
        driver.findElement(tosLinkText);
    }

    public void clickPrivayLinkText() {
        driver.findElement(privayLinkText);
    }
}
