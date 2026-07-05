package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

/**
 * Functional test cases covering the registration / sign-up form validation.
 */
public class RegistrationTest extends BaseTest {

    @Test(priority = 1, description = "Valid details should register the user successfully")
    public void testSuccessfulRegistration() {
        RegistrationPage page = new RegistrationPage(driver);
        page.fillForm("Boobalan N", "boobalan.test@example.com", "Secure@123", "Secure@123");
        page.submit();

        Assert.assertTrue(page.isRegistrationSuccessful(), "Registration should succeed with valid details");
    }

    @Test(priority = 2, description = "Mismatched passwords should show a validation error")
    public void testPasswordMismatch() {
        RegistrationPage page = new RegistrationPage(driver);
        page.fillForm("Boobalan N", "boobalan.test@example.com", "Secure@123", "Different@123");
        page.submit();

        Assert.assertTrue(page.hasValidationError(), "Validation error should show for mismatched passwords");
    }

    @Test(priority = 3, description = "Invalid email format should show a validation error")
    public void testInvalidEmailFormat() {
        RegistrationPage page = new RegistrationPage(driver);
        page.fillForm("Boobalan N", "not-an-email", "Secure@123", "Secure@123");
        page.submit();

        Assert.assertTrue(page.hasValidationError(), "Validation error should show for invalid email format");
    }

    @Test(priority = 4, description = "Empty required fields should show validation errors")
    public void testEmptyRequiredFields() {
        RegistrationPage page = new RegistrationPage(driver);
        page.fillForm("", "", "", "");
        page.submit();

        Assert.assertTrue(page.hasValidationError(), "Validation error should show when required fields are empty");
    }
}
