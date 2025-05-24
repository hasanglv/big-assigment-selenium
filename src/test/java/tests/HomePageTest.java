package tests;

import com.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://qa-practice.netlify.app/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testWelcomeTitle() {
        String expectedTitle = "Welcome!";
        Assert.assertEquals(homePage.getWelcomeTitle(), expectedTitle);
    }
}
