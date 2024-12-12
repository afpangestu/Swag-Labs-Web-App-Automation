import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    public void verifyLogo() {
        HomePage homePage = new HomePage(driver);
        homePage.checkLogoSwag();
    }
}
