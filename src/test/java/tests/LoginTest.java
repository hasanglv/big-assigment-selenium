package tests;

import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("admin@admin.com");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginSuccess(), "Login should be successful");
    }
}
