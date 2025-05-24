package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiPageTest extends BaseTest {

    @Test
    public void testMultiplePages() {
        String baseUrl = "https://qa-practice.netlify.app/";
        String[] pages = {
                "",                   // Home page
                "login",
                "register",
                "products_list",
                "graphql-testing",
                "api-testing",
        };

        for (String page : pages) {
            String url = baseUrl + page;
            driver.get(url);

            String title = driver.getTitle();
            System.out.println("Navigated to: " + url + " | Page Title: " + title);

            Assert.assertFalse(title.isEmpty(), "Title should not be empty for page: " + url);
        }
    }
}
