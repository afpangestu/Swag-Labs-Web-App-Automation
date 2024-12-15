import base.BaseUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.FooterMenu;
import page.LoginPage;

import java.util.ArrayList;

public class FooterTest {
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
        Assert.assertEquals(driver.getCurrentUrl(),baseUtil.getBaseUrl());
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
    }

    @Test(priority = 1)
    public void twitterTest() throws InterruptedException {
        FooterMenu footerMenu = new FooterMenu(driver);
        // click twitter button
        footerMenu.clickTwitterBtn();
        // initialization arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getTwitterUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getTwitterUrl());
        // close current tab (twitter)
        driver.close();
        // move to first tab (Swag labs)
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test(priority = 2)
    public void facebookTest() throws InterruptedException {
        for (int i=0; i<3; i++) {
            System.out.println("ini data ke-"+i);
        }
        FooterMenu footerMenu = new FooterMenu(driver);
        // click twitter button
        footerMenu.clickFacebookBtn();
        // initialization arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getFacebookUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getFacebookUrl());
        // close current tab (facebook)
        driver.close();
        // move to first tab (Swag labs)
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test(priority = 3)
    public void linkedInTest() throws InterruptedException {
        FooterMenu footerMenu = new FooterMenu(driver);
        // click twitter button
        footerMenu.clickLinkedInBtn();
        // initialization arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // move to tab 2
        driver.switchTo().window(tabs.get(1));
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getLinkedInUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getLinkedInUrl());
        // close current tab (LinkedIn)
        driver.close();
        // move to first tab (Swag labs)
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test(priority = 4)
    public void checkFooterTextTest() {
        FooterMenu footerMenu = new FooterMenu(driver);
        // assert footer text
        Assert.assertEquals(footerMenu.getFooterText(),"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }

    @Test(priority = 5)
    public void checkTosLinkTest() {
        FooterMenu footerMenu = new FooterMenu(driver);
        // check terms of service link
        footerMenu.checkTosLinkText();
    }

    @Test(priority = 6)
    public void checkPrivacyLinkTest() {
        FooterMenu footerMenu = new FooterMenu(driver);
        // check privacy link
        footerMenu.checkPrivacyLinkText();
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
