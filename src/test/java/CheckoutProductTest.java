import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.NavBarMenu;
import page.ProductDetailsPage;

public class CheckoutProductTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

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
    public void CheckoutViaProductTitle() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        NavBarMenu navBarMenu = new NavBarMenu(driver);

        homePage.clickProductTitle();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getProductDetailsUrl1());
        productDetailsPage.clickAddToCartBtnDetails();
        Assert.assertTrue(navBarMenu.getShoppingCartBadge() > 0);
        Thread.sleep(2000);
        productDetailsPage.clickBackToProductBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void CheckoutViaProductImage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        NavBarMenu navBarMenu = new NavBarMenu(driver);

        homePage.clickProductImg();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getProductDetailsUrl2());
        productDetailsPage.clickAddToCartBtnDetails();
        Assert.assertTrue(navBarMenu.getShoppingCartBadge() > 0);
        Thread.sleep(2000);
        productDetailsPage.clickBackToProductBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        Thread.sleep(2000);
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
