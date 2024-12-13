import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.NavBarMenu;

import java.time.Duration;

public class NavBarTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();
    Duration duration = Duration.ofSeconds(10);

    @BeforeClass
    public void setup() {
        // open browser and url
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUtil.getBaseUrl());
        Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getBaseUrl());
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
    }

    @Test(priority = 1)
    public void navAllItemsTest() {
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // click nav menu
        navBarMenu.clickNavMenuBtn();
        // click all items button
        navBarMenu.clickAllItemsBtn();
    }

    @Test(priority = 2)
    public void navAboutTest() {
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // click about
        navBarMenu.clickAboutBtn();
        // assert url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getAboutUrl());
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void navResetStateTest() throws InterruptedException {
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // locator "Add to cart" button
        By addToCartBtn = By.xpath("//*[contains(text(),'Add to cart')]");
        // locator "Remove" button
        By removeBtn = By.xpath("//*[contains(text(),'Remove')]");

        driver.findElement(addToCartBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn));

        System.out.println("Jumlah cart saat ini : " + navBarMenu.getShoppingCartBadge());
        if (navBarMenu.getShoppingCartBadge() > 0) {
            // click nav menu
            navBarMenu.clickNavMenuBtn();
            // click reset state button
            navBarMenu.clickResetStateBtn();
        } else {
            System.out.println("Eror");
        }
    }

    @Test(priority = 4)
    public void logoutTest() {
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // click logout button
        navBarMenu.clickLogoutBtn();
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
