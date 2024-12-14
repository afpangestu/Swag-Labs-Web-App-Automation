package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBarMenu {
    WebDriver driver;
    WebDriverWait wait;

    // contructor
    public NavBarMenu(WebDriver driver) {
        this.driver = driver;
        // explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locator
    By navMenubtn = By.xpath("//button[@id='react-burger-menu-btn']");
    By allItemsBtn = By.xpath("//a[@id='inventory_sidebar_link']");
    By aboutBtn = By.xpath("//a[@id='about_sidebar_link']");
    By logoutBtn = By.xpath("//a[@id='logout_sidebar_link']");
    By resetBtn = By.xpath("//a[@id='reset_sidebar_link']");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    // actions
    public void clickNavMenuBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navMenubtn)).click();
    }

    public void clickAllItemsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allItemsBtn)).click();
    }

    public void clickAboutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutBtn)).click();
    }

    public void clickLogoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).click();
    }

    public void clickResetStateBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetBtn)).click();
    }

    public int getShoppingCartBadge() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
