package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * Functional test cases covering the login workflow.
 */
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Valid credentials should log the user in successfully")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboard = loginPage.login("standard_user", "Valid@123");

        Assert.assertTrue(dashboard.isLoaded(), "Dashboard should load after valid login");
    }

    @Test(priority = 2, description = "Invalid password should show an error message")
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrongPassword");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        Assert.assertTrue(
                loginPage.getErrorMessage().toLowerCase().contains("invalid"),
                "Error message should mention invalid credentials"
        );
    }

    @Test(priority = 3, description = "Empty username field should show a validation error")
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "Valid@123");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for empty username");
    }

    @Test(priority = 4, description = "Empty password field should show a validation error")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for empty password");
    }

    @Test(priority = 5, description = "Locked-out user should not be able to log in")
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "Valid@123");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be shown for locked-out user");
    }
}
