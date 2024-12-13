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
    By logoSwagLabs = By.xpath("//div[@class='login_logo']");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    // actions
    public void clickNavMenuBtn() {
        driver.findElement(navMenubtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(allItemsBtn));
    }

    public void clickAllItemsBtn() {
        driver.findElement(allItemsBtn).click();
    }

    public void clickAboutBtn() {
        driver.findElement(aboutBtn).click();
    }

    public void clickLogoutBtn() {
        driver.findElement(logoutBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoSwagLabs));
    }

    public void clickResetStateBtn() {
        driver.findElement(resetBtn).click();
    }

    public double getShoppingCartBadge() {
        return Double.parseDouble(driver.findElement(cartBadge).getText());
    }
}
