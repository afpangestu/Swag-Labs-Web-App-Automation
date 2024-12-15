import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortItemTest {
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
    public void sortAZTest() {
        HomePage homePage = new HomePage(driver);
        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (WebElement x : elementList) {
            obtainedList.add(x.getText());
        }

        homePage.clickSortBtn();
        homePage.clickSortAZ();

        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertEquals(obtainedList, sortedList);
    }

    @Test(priority = 2)
    public void sortZATest() {
        HomePage homePage = new HomePage(driver);
        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (WebElement x : elementList) {
            obtainedList.add(x.getText());
        }

        homePage.clickSortBtn();
        homePage.clickSortZA();

        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        obtainedList.sort(Collections.reverseOrder());
        Assert.assertNotEquals(sortedList, obtainedList);
    }

    @Test(priority = 3)
    public void sortLoHiTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSortBtn();
        homePage.clickSortLoHi();
        Assert.assertTrue(homePage.getFirstPrice() <= homePage.getLastPrice());
        System.out.println(homePage.getFirstPrice()+" <= "+homePage.getLastPrice());
    }

    @Test(priority = 4)
    public void sortHiLoTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSortBtn();
        homePage.clickSortHiLo();
        Assert.assertTrue(homePage.getFirstPrice() >= homePage.getLastPrice());
        System.out.println(homePage.getFirstPrice()+" >= "+homePage.getLastPrice());
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
