package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverConfigTest extends BaseTest {

    @Test
    public void testOpenHomePage() {
        driver.get("https://qa-practice.netlify.app/");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        String expectedTitle = "QA Practice | Learn with RV";

        Assert.assertEquals(title, expectedTitle, "Page title should match expected value.");
    }
}
