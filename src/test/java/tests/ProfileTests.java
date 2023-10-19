package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {
    @Test(priority = 1)
    public void visitsTheProfilePage() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.loginLink().click();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.loginButton().click();
        wait
                .withMessage("URL does not contain /home")
                .until(ExpectedConditions.urlContains("/home"));
        navPage.myProfileLink().click();
        wait
                .withMessage("URL does not contain /profile")
                .until(ExpectedConditions.urlContains("/profile"));
        profilePage.waitUntilLoadDialogIsInvisible();
        Assert.assertEquals(
                profilePage.emailField().getAttribute("value"), email, "Email field attribute value is not " + email
        );
    }
}
