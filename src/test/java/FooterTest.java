import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test
    public void twitterTest()  {
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
        driver.switchTo().window(tabs.getFirst());
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test
    public void facebookTest()  {
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
        driver.switchTo().window(tabs.getFirst());
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test
    public void linkedInTest()  {
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
        // close current tab (linkedin)
        driver.close();
        // move to first tab (Swag labs)
        driver.switchTo().window(tabs.getFirst());
        // assert the url
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
        // print output to terminal
        System.out.println("Link Actual: " + driver.getCurrentUrl() +" Link Expected: " +baseUtil.getHomePageUrl());
    }

    @Test
    public void privacyPolicyTest() {
        
    }

    @Test
    public void termsOfServiceTest() {

    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
