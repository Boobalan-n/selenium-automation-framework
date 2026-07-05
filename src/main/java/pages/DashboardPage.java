package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Dashboard/Home page shown after successful login.
 */
public class DashboardPage extends BasePage {

    private final By welcomeBanner = By.id("welcome-banner");
    private final By logoutLink = By.linkText("Logout");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(welcomeBanner);
    }

    public String getWelcomeText() {
        return getText(welcomeBanner);
    }

    public void logout() {
        click(logoutLink);
    }
}
