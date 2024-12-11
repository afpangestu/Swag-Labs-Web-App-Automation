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
    By footerText = By.xpath("//div[@class='footer_copy']");

    // linktext itu case sensitif, tapi harus 100% matches with the actual link text
//    By tosLinkText = By.linkText("Sauce Labs Backpack");
    // partiallinktext itu case sensitif, tapi selama mengandung kata actualnya dia akan tetap jalan
//    By tosLinkText = By.partialLinkText("Backpack");

    By tosLinkText = By.partialLinkText("Terms of Service");
    By privacyLinkText = By.partialLinkText("Privacy Policy");

    // actions
    public void clickTwitterBtn() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(twitterBtn)
        );
        driver.findElement(twitterBtn).click();
    }

    public void clickFacebookBtn() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(facebookBtn)
        );
        driver.findElement(facebookBtn).click();
    }

    public void clickLinkedInBtn() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(linkedInBtn)
        );
        driver.findElement(linkedInBtn).click();
    }

    public String getFooterText() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(footerText)
        );
        return driver.findElement(footerText).getText();
    }

    public void checkTosLinkText() {
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(tosLinkText)
        );
        driver.findElement(tosLinkText).click();
    }

    public void checkPrivacyLinkText() {
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.elementToBeClickable(privacyLinkText)
        );
        driver.findElement(privacyLinkText).click();
    }
}
