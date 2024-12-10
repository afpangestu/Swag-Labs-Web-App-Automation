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
import page.NavBarPage;

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
        NavBarPage navBarPage = new NavBarPage(driver);
        // click nav menu
        navBarPage.clickNavMenuBtn();
        // click all items button
        navBarPage.clickAllItemsBtn();
    }

    @Test(priority = 2)
    public void navAboutTest() {
        NavBarPage navBarPage = new NavBarPage(driver);
        // click about
        navBarPage.clickAboutBtn();
        // assert url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getAboutUrl());
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void navResetStateTest() {
        NavBarPage navBarPage = new NavBarPage(driver);
        // locator "Add to cart" button
        By addToCartBtn = By.xpath("//*[contains(text(),'Add to cart')]");
        // locator "Remove" button
        By removeBtn = By.xpath("//*[contains(text(),'Remove')]");

        driver.findElement(addToCartBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(removeBtn)
        );

        double totalCart = Double.parseDouble(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText());
        System.out.println("jumlah cart saat ini : " + totalCart);
        if (totalCart > 0) {
            // click nav menu
            navBarPage.clickNavMenuBtn();
            // click reset state button
            navBarPage.clickResetStateBtn();
        }
    }

    @Test(priority = 4)
    public void logoutTest() {
        NavBarPage navBarPage = new NavBarPage(driver);
        // click logout button
        navBarPage.clickLogoutBtn();
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
