import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LoginPage;

public class LoginTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

    @DataProvider(name = "credentials")
    // data user
    public Object[][] getData() {
        return new Object[][] {
                {"","","blank"},
                {"username_salah","secret_sauce","wrong"},
                {"standard_user","secret_sauce","success"},
        };
    }

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
    }

    @Test(dataProvider = "credentials")
    public void loginUser(String username, String password, String scenario) throws InterruptedException {
        // login negative and positive
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();

        // validate blank, wrong, success scenario
        switch (scenario) {
            case "blank" -> loginPage.setErrorMsgBlank();
            case "wrong" -> loginPage.setErrorMsgIncorrect();
            case "success" -> {
                Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
                System.out.println("Login Test Success");
                Thread.sleep(2000);
            }
        }
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
