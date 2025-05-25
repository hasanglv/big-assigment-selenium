package tests;

import com.example.pages.LoginPage;
import com.example.pages.RecoverPasswordPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecoverPasswordTest extends BaseTest {

    private LoginPage loginPage;
    private RecoverPasswordPage recoverPasswordPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");
        loginPage = new LoginPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
    }

    @Test
    public void testRecoverPasswordAfterLogin() {
        // Login first
        loginPage.enterUsername("admin@admin.com");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        // Navigate to Recover Password page
        driver.get("https://qa-practice.netlify.app/recover-password");

        // Send email in recover password form
        recoverPasswordPage.enterEmail("admin@admin.com");
        recoverPasswordPage.clickRecoverButton();

        // Verify success message
        Assert.assertTrue(recoverPasswordPage.isSuccessMessageDisplayed(), "Success message should be displayed");
    }
}
