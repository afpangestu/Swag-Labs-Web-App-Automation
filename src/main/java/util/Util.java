package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Util {
    WebDriver driver;

    // contructor
    public Util(WebDriver driver) {
        this.driver = driver;
    }

    public int getTotalItem(String xpath) {
        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        for (WebElement x : elementList) {
            obtainedList.add(x.getText());
        }
        return obtainedList.size();
    }
}
