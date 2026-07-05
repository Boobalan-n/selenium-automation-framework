package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;

/**
 * Every test class extends this. Keeps setup/teardown logic in one place
 * instead of repeating @BeforeMethod / @AfterMethod in every test file.
 */
public class BaseTest {

    protected WebDriver driver;

    @Parameters({"baseUrl"})
    @BeforeMethod
    public void setUp(String baseUrl) {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
