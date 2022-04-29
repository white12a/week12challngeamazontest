import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyLaptop() {
        clickOnElement(By.xpath("//span[@class='a-button a-button-primary']/span"));
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));
        clickOnElement(By.xpath("//div[@id='brandsRefinements']/ul/li[1]/span/a/div"));
        List<WebElement> laptopList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int actualNumber = laptopList.size();
        int expectedNumber = 30;
        Assert.assertEquals(actualNumber, expectedNumber);
        for (WebElement names : laptopList) {
            System.out.println(names.getText());
        }
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }

}
