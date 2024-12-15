import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;

public class HomePageTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

    @BeforeClass
    public void setup() {
        // open browser and url
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseUtil.getBaseUrl());
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getBaseUrl());
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
    }

    @Test(priority = 1)
    public void verifyLogoTest() {
        HomePage homePage = new HomePage(driver);
        // assert the url
        Assert.assertTrue(homePage.checkLogoSwag());
        System.out.println("Logo is '"+ homePage.getTextLogo() +"' visible");
    }

    @Test(priority = 3)
    public void cartBtnTest() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        // click cart button
        homePage.clickCartBtn();
        Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getCartUrl());
        // back to home page
        cartPage.clickContinueShoppingBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        System.out.println("Cart and ContinueShopping button is working fine");
    }

    @Test(priority = 2)
    public void allProductTest() {
        HomePage homePage = new HomePage(driver);
        // assert each product element
        Assert.assertTrue(homePage.getAllProduct());
        System.out.println("Get All Product success");
    }

    @Test(priority = 4)
    public void productDetailsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        // open product details
        String productTitle = homePage.getProductTitle();
        String productImg = homePage.getProductImg();
        String productDesc = homePage.getProductDesc();
        String productPrice = homePage.getProductPrice();
        // click product to open product details
        homePage.clickProductTitle();
        // assert url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getProductDetailsUrl1());
        // assert each product details
        Assert.assertEquals(productDetailsPage.getTitleProductDetails(), productTitle);
        System.out.println("Title Actual: "+productDetailsPage.getTitleProductDetails()+" Title Expected: "+productTitle);
        Assert.assertEquals(productDetailsPage.getImageProductDetails(), productImg);
        System.out.println("Link Img Actual: "+productDetailsPage.getImageProductDetails()+" Link Img Expected: "+productImg);
        Assert.assertEquals(productDetailsPage.getDescProductDetails(), productDesc);
        System.out.println("Desc Actual: "+productDetailsPage.getDescProductDetails()+" Desc Expected: "+productDesc);
        Assert.assertEquals(productDetailsPage.getPriceProductDetails(), productPrice);
        System.out.println("Price Actual: "+productDetailsPage.getPriceProductDetails()+" Price Expected: "+productPrice);
        System.out.println("Product Details Test is Successful");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
