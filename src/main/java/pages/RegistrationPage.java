package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Registration/Sign-up form.
 * Used for functional form-validation test scenarios.
 */
public class RegistrationPage extends BasePage {

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By submitButton = By.id("submitBtn");
    private final By fieldValidationError = By.cssSelector(".field-error");
    private final By successMessage = By.id("registration-success");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String name, String email, String password, String confirmPassword) {
        type(nameField, name);
        type(emailField, email);
        type(passwordField, password);
        type(confirmPasswordField, confirmPassword);
    }

    public void submit() {
        click(submitButton);
    }

    public boolean hasValidationError() {
        return isDisplayed(fieldValidationError);
    }

    public String getValidationErrorText() {
        return getText(fieldValidationError);
    }

    public boolean isRegistrationSuccessful() {
        return isDisplayed(successMessage);
    }
}
