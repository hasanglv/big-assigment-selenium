package tests;

import com.example.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class FileUploadTest extends BaseTest {

    private FileUploadPage fileUploadPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("https://qa-practice.netlify.app/file-upload");
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test
    public void testFileUpload() throws Exception {

        URL resource = getClass().getClassLoader().getResource("sample-file.txt");
        Assert.assertNotNull(resource, "Sample file not found in resources folder");

        File file = new File(resource.toURI());
        String filePath = file.getAbsolutePath();

        fileUploadPage.uploadFile(filePath);
        fileUploadPage.clickSubmit();
        Assert.assertTrue(fileUploadPage.isUploadSuccessDisplayed(), "Upload success message should be displayed");
    }


    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
