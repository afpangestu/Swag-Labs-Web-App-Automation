import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutProductTest {
    WebDriver driver;
    BaseUtil baseUtil = new BaseUtil();

    @DataProvider(name = "checkout_information")
    // data your information
    public Object[][] getData() {
        return new Object[][] {
                {"","","","blank"},
                {"aji fauzi","pangestu","10784","Success"},
        };
    }

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
    public void addToCartViaProductTitle() {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // open product details via product title in home page
        homePage.clickProductTitle();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getProductDetailsUrl1());
        // add to cart
        productDetailsPage.clickAddToCartBtnDetails();
        Assert.assertTrue(navBarMenu.getShoppingCartBadge() > 0);
        // click back button to home page
        productDetailsPage.clickBackToProductBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
    }

    @Test(priority = 2)
    public void addToCartViaProductImage() {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        // open product details via product image in home page
        homePage.clickProductImg();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getProductDetailsUrl2());
        // add to cart
        productDetailsPage.clickAddToCartBtnDetails();
        Assert.assertTrue(navBarMenu.getShoppingCartBadge() > 0);
        // click back button to home page
        productDetailsPage.clickBackToProductBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
    }


    @Test(priority = 3, dataProvider = "checkout_information")
    public void checkoutProduct(String firstName, String lastName, String zipCode, String scenario) {
        HomePage homePage = new HomePage(driver);
        NavBarMenu navBarMenu = new NavBarMenu(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        // click cart button
        homePage.clickCartBtn();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getCartUrl());
        // store all item in the cart to List
        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='cart_item']"));
        for (WebElement x : elementList) {
            obtainedList.add(x.getText());
        }
        // amount product in the cart page
        int amountItem = obtainedList.size();
        Assert.assertEquals(amountItem, navBarMenu.getShoppingCartBadge());
        // click checkout
        cartPage.clickContinueToStepOne();
        Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getCheckoutStepOneUrl());
        // input fields
        checkoutStepOnePage.setFirstName(firstName);
        checkoutStepOnePage.setLastName(lastName);
        checkoutStepOnePage.setZipCode(zipCode);
        // click continue button
        checkoutStepOnePage.clickContinueBtn();
        // validate blank input and success scenario
        switch (scenario) {
            case "blank" -> checkoutStepOnePage.getErrorMsg();
            case "success" -> {
                Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getCheckoutStepTwoUrl());
                // click finish ang navigate to Checkout Complete page
                checkoutStepTwoPage.clickFinishBtn();
                Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getCheckoutCompleteUrl());
                Assert.assertTrue(checkoutCompletePage.getCompleteText());
                // click back to home
                checkoutCompletePage.clickBackToHomeBtn();
                Assert.assertEquals(driver.getCurrentUrl(), baseUtil.getHomePageUrl());
                System.out.println("Checkout Product Success");
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
