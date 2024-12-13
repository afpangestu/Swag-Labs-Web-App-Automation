import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;
import page.LoginPage;

public class HomePageTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

    @BeforeClass
    public void setup() {
        // open browser and url
        driver = new ChromeDriver();
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

    @Test
    public void verifyLogoTest() {
        HomePage homePage = new HomePage(driver);
        // assert the url
        Assert.assertTrue(homePage.checkLogoSwag());
        System.out.println("Logo is '"+ homePage.getTextLogo() +"' visible");
    }

    @Test
    public void cartBtnTest() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickCartBtn();
        Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getCartUrl());
        cartPage.clickContinueShoppingBtn();
        System.out.println("Cart and ContinueShopping button is working fine");
    }

    @Test
    public void allProductTest() {
        HomePage homePage = new HomePage(driver);
        // assert each product element
        Assert.assertTrue(homePage.getAllProduct());
        System.out.println("Get All Product success");
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
