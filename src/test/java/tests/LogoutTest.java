package tests;

import com.example.pages.LoginPage;
import com.example.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testLoginLogoutAndGoHome() {
        loginPage.enterUsername("admin@admin.com");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginSuccess(), "Login should be successful");

        driver.findElement(By.linkText("Log Out")).click();

        homePage.clickHome();

        String welcomeTitle = homePage.getWelcomeTitle();
        Assert.assertEquals(welcomeTitle, "Welcome!", "Should navigate to Home page and see welcome message");
    }
}
