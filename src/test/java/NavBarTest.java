import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.NavBarPage;

public class NavBarTest {
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
        // click nav menu
        navBarPage.clickNavMenuBtn();
        // click reset state button
        navBarPage.clickResetStateBtn();
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
