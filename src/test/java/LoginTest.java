import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LoginPage;

public class LoginTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUtil.getBaseUrl());
        Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getBaseUrl());
    }

    @Test(dataProvider = "credentials")
    public void loginAllUser(String username, String password, String scenario) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();

        switch (scenario) {
            case "blank" -> loginPage.setErrorMsgBlank();
            case "wrong" -> loginPage.setErrorMsgIncorrect();
            case "success" -> {
                Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getHomePageUrl());
                System.out.println("Login successful");
                loginPage.logout();
            }
        }
        Thread.sleep(2000);
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][] {
                {"","","blank"},
                {"username_salah","secret_sauce","wrong"},
                {"standard_user","secret_sauce","success"},
        };
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
