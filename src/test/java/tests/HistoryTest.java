package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HistoryTest extends BaseTest {

    private final String homeUrl = "https://qa-practice.netlify.app/";
    private final String[] testPages = {
            "graphql-testing",
            "api-testing",
            "products_list"
    };

    @Test
    public void testBrowserBackNavigatesThroughHistory() throws InterruptedException {

        driver.get(homeUrl);
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);

        for (String page : testPages) {
            driver.get(homeUrl + page);
            Assert.assertTrue(driver.getCurrentUrl().contains(page), "Should be on " + page);
        }

        for (int i = testPages.length - 1; i >= 0; i--) {
            driver.navigate().back();

            Thread.sleep(1500);

            String expectedUrl = (i == 0) ? homeUrl : homeUrl + testPages[i - 1];
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Should navigate back to " + expectedUrl);
        }
    }
}
